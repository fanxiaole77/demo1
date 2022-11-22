package com.example.myapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreate {

    val url = "http://192.168.1.211:10001/"

    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun <T>create(service:Class<T>):T = retrofit.create(service)

    val  smartCityService = create(SmartCityApi::class.java)

}