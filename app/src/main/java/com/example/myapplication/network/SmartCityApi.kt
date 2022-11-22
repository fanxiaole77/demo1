package com.example.myapplication.network

import com.example.myapplication.SmartCityApplication
import retrofit2.Call
import retrofit2.http.*

interface SmartCityApi {

    @POST("/prod-api/api/login")
    fun postLogin(@Body user:Login):Call<Message>


    @POST("/prod-api/api/register")
    fun postRegister(@Body user:Register):Call<Message>

    @GET("/prod-api/api/rotation/list")
    fun getHomeBanner():Call<HomeBanner>

    @GET("/prod-api/api/service/list")
    fun getHomeService():Call<HomeService>

    @GET("/prod-api/press/category/list")
    fun getNewsType():Call<NewsType>

    @GET("/prod-api/press/press/list")
    fun getHot(@Query("hot") hot:String = "Y"):Call<NewsLIst>

    @GET("/prod-api/press/press/list")
    fun getNewsList(@Query("type")type:String?,@Query("title")title:String?):Call<NewsLIst>

    @GET("/prod-api/press/press/{id}")
    fun getNewsContent(@Path("id")id:Int):Call<NewsContent>

    @GET("/prod-api/api/common/user/getInfo")
    fun getUserInfo(@Header("Authorization")Authorization:String = SmartCityApplication.TOKEN):Call<UserInfo>

}