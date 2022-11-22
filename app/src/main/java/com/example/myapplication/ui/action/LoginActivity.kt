package com.example.myapplication.ui.action

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.extensions.edit
import com.example.myapplication.extensions.sharedPreferences
import com.example.myapplication.extensions.showToast
import com.example.myapplication.network.Login
import com.example.myapplication.network.Message
import com.example.myapplication.network.ServiceCreate
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()
        window.statusBarColor = Color.TRANSPARENT

        login.setOnClickListener {
            val user = et_user.text.toString()
            val pass = et_pass.text.toString()
            ServiceCreate.smartCityService.postLogin(Login(pass,user)).enqueue(object :Callback<Message>{
                override fun onFailure(p0: Call<Message>, p1: Throwable) {
                    Log.i("msg","aaaa",p1)
                }

                override fun onResponse(p0: Call<Message>, p1: Response<Message>) {
                   val body = p1.body()
                    if (body != null){
                        Log.d("msg","${body.msg}")
                        if (body.code == 200){
                            body.msg.showToast()
                            sharedPreferences.edit {
                                putString("token",body.token)
                            }
                            startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                        }else{
                            body.msg.showToast()
                        }
                    }
                }

            })
        }
    }
}