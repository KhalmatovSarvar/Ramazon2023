package com.shersar.ramazon2023.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var backPressedCounter = 0

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        //this is initView
    }



    private fun initView() {

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()
        //setting up bottom nav with navController
        binding.bottomNavigation.setupWithNavController(navController)

    }


    override fun onBackPressed() {
        if (binding.bottomNavigation.selectedItemId == R.id.homeScreen) {
            if (isTaskRoot) {
                if (backPressedCounter >= 1) {
                    super.onBackPressed()
                } else {
                    Toast.makeText(this, "Dasturdan chiqish uchun yana bir marta bosing", Toast.LENGTH_SHORT).show()
                    backPressedCounter++
                    Handler(Looper.getMainLooper()).postDelayed({
                        backPressedCounter = 0
                    }, 2000)
                }
            } else {
                super.onBackPressed()
            }
        } else {
            super.onBackPressed()
        }
    }


}