package com.example.myapplication

import android.app.Fragment
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.ColorInt
import androidx.annotation.RequiresApi
import com.example.myapplication.extensions.sharedPreferences
import com.example.myapplication.extensions.showToast
import com.example.myapplication.ui.data.DataFragment
import com.example.myapplication.ui.home.HomeFragment
import com.example.myapplication.ui.lawyer.LawyerFragment
import com.example.myapplication.ui.litter.LitterFragment
import com.example.myapplication.ui.me.MeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    lateinit var bottom1:BottomNavigationView
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SmartCityApplication.TOKEN = sharedPreferences.getString("token","").toString()

        loadFragment(HomeFragment())

        bottom1 = findViewById(R.id.bottom)

        val id = intent.getIntExtra("id",0)
        Log.d("id",id.toString())
        if (id == 1){
            bottom.selectedItemId = R.id.nav_litter
        }

        supportActionBar?.hide()
        window.statusBarColor = Color.TRANSPARENT

        bottom.setOnNavigationItemSelectedListener {
            Log.d("id",id.toString())
            when(it.itemId){
                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                }
                R.id.nav_litter -> {
                    loadFragment(LitterFragment())
                }
                R.id.nav_data -> {
                    loadFragment(DataFragment())
                }
                R.id.nav_lawyer -> {
                    loadFragment(LawyerFragment())
                }
                R.id.nav_me -> {
                    loadFragment(MeFragment())
                }
            }
            true
        }

    }

    private fun loadFragment(fm:androidx.fragment.app.Fragment){
        val aa = supportFragmentManager.beginTransaction()
        aa.replace(R.id.fragment,fm)
        aa.commit()
    }
}