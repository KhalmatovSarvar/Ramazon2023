package com.shersar.ramazon2023.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }



    private fun initView() {

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()
        //setting up bottom nav with navController
        binding.bottomNavigation.setupWithNavController(navController)
        binding.bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.homeScreen -> {
                    navController.navigate(R.id.homeScreen)

                    true
                }
                R.id.tasbehScreen -> {
                    navController.navigate(R.id.tasbehScreen)
                    navController.popBackStack(R.id.qiblaScreen,false)
                    navController.popBackStack(R.id.settingsScreen,false)

                    true
                }
                R.id.qiblaScreen -> {
                    navController.navigate(R.id.qiblaScreen)
                    navController.popBackStack(R.id.tasbehScreen,false)
                    navController.popBackStack(R.id.settingsScreen,false)
                    true
                }
                R.id.settingsScreen -> {
                    navController.navigate(R.id.settingsScreen)
                    navController.popBackStack(R.id.tasbehScreen,false)
                    navController.popBackStack(R.id.qiblaScreen,false)
                    true
                }

                else -> false
            }
        }


    }

// i was here
    override fun onBackPressed() {
        if (binding.bottomNavigation.selectedItemId == R.id.homeScreen) {
            if (isTaskRoot) {
                finish()
            } else {
                super.onBackPressed()
            }
        } else {
            super.onBackPressed()
        }
    }
}