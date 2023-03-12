package com.shersar.ramazon2023.ui.tasbeh.drawer

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.tabs.TabLayout
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.databinding.ItemDrawerBinding
import com.shersar.ramazon2023.databinding.ScreenHomeBinding
import kotlinx.android.synthetic.main.item_drawer.view.*
import viewBinding

class ItemDrawerScreen : Fragment(R.layout.item_drawer) {

    private val binding by viewBinding { ItemDrawerBinding.bind(it) }
    private lateinit var navController: NavController

    lateinit var tabLayout: TabLayout
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {
        tabLayout =binding.tabLayout
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()
        //setting up bottom nav with navController

        
        val tabs = listOf(
            Pair("Zikrlar", R.id.zikrScreen),
            Pair("Salovatlar", R.id.salovatScreen)
        )
        Toast.makeText(requireContext(), "${tabs.size}", Toast.LENGTH_SHORT).show()
        Log.d("RRR", "demo ${tabs.toString()}")
        tabs.forEach { (title, destinationId) ->
            val tab = tabLayout.newTab().setText(title)
            tab.setTag(destinationId)
            tabLayout.addTab(tab)
            Log.d("###", "========== $title")

            tab.view.setOnClickListener {
                val destination = navController.graph.findNode(destinationId)!!
                navController.navigate(destination.id)
            }
        }
        // Update the selected tab when the navigation changes
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val destinationId = destination.id
            val selectedTab = tabLayout.getTabAt(tabs.indexOfFirst { it.second == destinationId })
            selectedTab?.select()
        }
    }
}