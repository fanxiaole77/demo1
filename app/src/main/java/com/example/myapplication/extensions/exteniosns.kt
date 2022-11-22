package com.example.myapplication.extensions

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import com.example.myapplication.SmartCityApplication
import java.time.Duration

fun CharSequence.showToast(duration:Int = Toast.LENGTH_SHORT){
    Toast.makeText(SmartCityApplication.context,toString(),duration).show()
}

fun SharedPreferences.edit(action:SharedPreferences.Editor.() -> Unit){
    val editor = edit()
    action(editor)
    editor.apply()
}

val sharedPreferences:SharedPreferences  = SmartCityApplication.context.getSharedPreferences(
    "Preferences",
    Context.MODE_PRIVATE
)