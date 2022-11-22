package com.example.myapplication.ui.activity.`fun`

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.extensions.ItemAdapter
import com.example.myapplication.network.HomeService
import com.example.myapplication.network.NewsType
import com.example.myapplication.network.ServiceCreate
import com.example.myapplication.ui.home.AA
import kotlinx.android.synthetic.main.activity_fun.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FunActivity : AppCompatActivity() {
    /**
     * 更多服务
     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fun)

        supportActionBar?.hide()
        window.statusBarColor = Color.TRANSPARENT

        ServiceCreate.smartCityService.getHomeService().enqueue(object : Callback<HomeService> {
            override fun onFailure(p0: Call<HomeService>, p1: Throwable) {
            }

            override fun onResponse(p0: Call<HomeService>, p1: Response<HomeService>) {
                val body = p1.body()
                if (body != null) {
                    val adapter = ItemAdapter(R.layout.item_service, body.rows, DD::class.java)
                    rv_fun.layoutManager = GridLayoutManager(this@FunActivity, 5)
                    rv_fun.adapter = adapter
                }
            }

        })

    }
}

class DD(view: View) : ItemAdapter.MyViewHolder(view) {

    val name: TextView = view.findViewById(R.id.service_text)
    val image: ImageView = view.findViewById(R.id.service_image)
    override fun binViewHolder(list: List<Any?>, position: Int, data: List<Any?>) {
        name.text = (data[position] as HomeService.Row).serviceName
        Glide.with(image).load(ServiceCreate.url + (data[position] as HomeService.Row).imgUrl)
            .into(image)

        when ((data[position] as HomeService.Row).serviceName) {
//                val intent = Intent(this@OtherActivity, MainActivity::class.java)
//            intent.putExtra("id", 1)
//                    startActivity (intent)
            "垃圾分类" -> {
                itemView.setOnClickListener {
                    name.context.startActivity(Intent(name.context,MainActivity::class.java).apply {
                        putExtra("id",1)
                    })
                }
            }
        }
    }
}