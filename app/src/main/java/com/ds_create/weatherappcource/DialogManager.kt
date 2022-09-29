package com.ds_create.weatherappcource

import android.app.AlertDialog
import android.content.Context
import android.widget.EditText

object DialogManager {

    fun locationSettingsDialog(context: Context, listener: Listener) {
        val builder = AlertDialog.Builder(context)
        val dialog = builder.create()
        dialog.setTitle("Включить определенеие местоположения?")
        dialog.setMessage("Геолокация отключена." +
                " Для дальнейшей работы необходим доступ к метоположению устройства. " +
                "Вы хотите включить геолокацию?")
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK") { _,_->
            listener.onClick(null)
            dialog.dismiss()
        }
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel") { _,_->
            dialog.dismiss()
        }
        dialog.show()
    }

    fun searchCityByNameDialog(context: Context, listener: Listener) {
        val builder = AlertDialog.Builder(context)
        val edName = EditText(context)
        builder.setView(edName)
        val dialog = builder.create()
        dialog.setTitle("Выберите город:")
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK") { _,_->
            listener.onClick(edName.text.toString())
            dialog.dismiss()
        }
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel") { _,_->
            dialog.dismiss()
        }
        builder.setView(edName)
        dialog.show()
    }

    interface Listener {
        fun onClick(name: String?)
    }
}