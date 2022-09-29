package com.ds_create.weatherappcource.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ds_create.weatherappcource.adapters.WeatherAdapter
import com.ds_create.weatherappcource.databinding.FragmentDaysBinding
import com.ds_create.weatherappcource.models.WeatherModel
import com.ds_create.weatherappcource.viewmodel.MainViewModel

class DaysFragment : Fragment(), WeatherAdapter.Listener {

    private var _binding: FragmentDaysBinding? = null
    private val binding: FragmentDaysBinding
    get() = _binding ?: throw RuntimeException("FragmentDaysBinding is null")

    private lateinit var weatherAdapter: WeatherAdapter
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDaysBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        viewModel.liveDataList.observe(viewLifecycleOwner) {
            weatherAdapter.submitList(it.subList(1, it.size))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun init() = with(binding) {
        weatherAdapter = WeatherAdapter(this@DaysFragment)
        rcView.layoutManager = LinearLayoutManager(activity)
        rcView.adapter = weatherAdapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = DaysFragment()
    }

    override fun onClick(item: WeatherModel) {
       viewModel.liveDataCurrent.value = item
    }
}