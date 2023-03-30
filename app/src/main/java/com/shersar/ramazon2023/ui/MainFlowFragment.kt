package com.shersar.ramazon2023.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.databinding.FragmentMainFlowBinding
import dagger.hilt.android.AndroidEntryPoint
import viewBinding

@AndroidEntryPoint
class MainFlowFragment : BaseFlowFragment(R.layout.fragment_main_flow, R.id.nav_host_fragment) {
    private val binding by viewBinding { FragmentMainFlowBinding.bind(it) }

    override fun setupNavigation(navController: NavController) {
        super.setupNavigation(navController)

        binding.bottomNavigation.setupWithNavController(navController)
    }

}