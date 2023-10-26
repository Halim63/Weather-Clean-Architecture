package com.halim.weather.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.halim.weather.R
import com.halim.weather.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
     val fragment=WeatherListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initToolBar()
    }

    private fun initView() {
        addFragment(fragment)
    }

    private fun initToolBar() = setSupportActionBar(binding.toolbar)
//    private fun initNavigation() {
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
//        navController = navHostFragment.navController
//    }

    @SuppressLint("CommitTransaction")
    private fun addFragment(fragment: WeatherListFragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

}