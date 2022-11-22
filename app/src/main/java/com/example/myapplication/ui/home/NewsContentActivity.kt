package com.example.myapplication.ui.home

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.network.NewsContent
import com.example.myapplication.network.ServiceCreate
import kotlinx.android.synthetic.main.activity_news_content.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsContentActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_content)
        supportActionBar?.hide()
        window.statusBarColor = Color.YELLOW

        w.setNavigationIcon(R.drawable.ic_baseline_keyboard_arrow_left_24)
        w.setOnClickListener { finish() }

        val id = intent.getIntExtra("newsid",0)

        ServiceCreate.smartCityService.getNewsContent(id).enqueue(object :Callback<NewsContent>{
            override fun onFailure(p0: Call<NewsContent>, p1: Throwable) {
            }

            override fun onResponse(p0: Call<NewsContent>, p1: Response<NewsContent>) {
                val body = p1.body()
                if (body != null){
                    news_content_title.text = body.data.title
                    news_content_content.text = Html.fromHtml(body.data.content)
                    Glide.with(this@NewsContentActivity).load(ServiceCreate.url + body.data.cover).into(news_content_image)
                }
            }

        })
    }
}