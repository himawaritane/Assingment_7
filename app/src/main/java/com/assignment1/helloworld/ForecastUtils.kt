package com.assignment1.helloworld

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

fun formatTempForDisplay(temp: Float, tempDisplaySetting: TempDisplaySetting): String {
    return when(tempDisplaySetting){
        TempDisplaySetting.Fahrenheit-> String.format("%.2f °F", temp)
        TempDisplaySetting.Celsius ->  {
            val temp = (temp - 32) * (5f/9f)
            String.format("%.2f °C", temp)
        }
    }
}

fun showTempDisplaySettingDialog(context: Context, tempDisplaySettingManager: TempDisplaySettingManager){
    val dialogBuilder = AlertDialog.Builder(context)
        .setTitle("choose Display Units")
        .setMessage("chosse which tempetature unit to use for temperature display")
        .setPositiveButton("°F"){ _,_ ->
            tempDisplaySettingManager.updateSetting(TempDisplaySetting.Fahrenheit)
            //Toast.makeText(this,"show using F", Toast.LENGTH_SHORT).show()
        }
        .setNeutralButton("°C") { _, _ ->
            tempDisplaySettingManager.updateSetting(TempDisplaySetting.Celsius)
            //Toast.makeText(this, "show using C", Toast.LENGTH_SHORT).show()
        }
        .setOnDismissListener{
            Toast.makeText(context,"setting will take effect on App restart", Toast.LENGTH_SHORT).show()
        }
    dialogBuilder.show()
}