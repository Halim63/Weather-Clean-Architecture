package com.halim.weather.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.halim.weather.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var fragment:WeatherListFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(fragment)
    }

    private fun addFragment(fragment: WeatherListFragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}