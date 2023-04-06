package com.shersar.ramazon2023.ui.tasbeh

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.adapters.ViewPagerAdapter
import com.shersar.ramazon2023.data.local.entity.Zikr
import com.shersar.ramazon2023.databinding.ScreenTasbehBinding
import com.shersar.ramazon2023.ui.tasbeh.viewmodel.TasbehViewmodel
import com.shersar.ramazon2023.utils.CustomDialog
import com.shersar.ramazon2023.utils.UiStateObject
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.screen_item1.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.relex.circleindicator.CircleIndicator3
import viewBinding
import javax.inject.Inject

@AndroidEntryPoint
class TasbehScreen : Fragment(R.layout.screen_tasbeh) {

    private val binding by viewBinding { ScreenTasbehBinding.bind(it) }
    private val viewModelTasbeh: TasbehViewmodel by activityViewModels()
    private lateinit var adapterFragments: ViewPagerAdapter
    private lateinit var viewPagerr: ViewPager2



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Log.d("TAG", "onViewCreated: ok")

        initview()
        initViewPager()
        initCounts()
        setupDarweLayout()
        setupZikrObservers()
    }

    private fun initview() {
        val header: View
        binding.ivVerMore.setOnClickListener {
            binding.drawerlayout.openDrawer(GravityCompat.END)
        }
        binding.apply {
            header = navView.getHeaderView(0)
        }
        initTabs(header, binding.drawerlayout)
    }


    private fun setupDarweLayout() {
    }

    private fun initViewPager() {
        viewPagerr = binding.viewpager2
        adapterFragments = ViewPagerAdapter(requireActivity())
        adapterFragments.fragments.add(Item1Screen())
        adapterFragments.fragments.add(Item2Screen())
        viewPagerr.adapter = adapterFragments

        val circleIndicator: CircleIndicator3 = binding.circleIndicator

        // Set the CircleIndicator with ViewPager2
        circleIndicator.setViewPager(viewPagerr)
    }

    private fun initTabs(header: View, drawerLayout: DrawerLayout) {
        val viewPager2: ViewPager2 = header.findViewById(R.id.viewpager2)
        val tabLayout: TabLayout = header.findViewById(R.id.tabLayout)

        viewPager2.adapter =
            FragmentAdapter( drawerLayout,requireActivity() as AppCompatActivity)
//        viewPager2.isUserInputEnabled = false
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> tab.text = "Zikrlar"
                1 -> tab.text = "Salovatlar"
                else -> tab.text = "Salovatlar"
            }
        }.attach()
//        FragmentAdapter( drawerLayout,requireActivity() as AppCompatActivity)
    }

    private fun initCounts() {

        binding.ivMoreVerDot.setOnClickListener {
            val customDialog = CustomDialog(requireContext())
            customDialog.setTitle("Custom Dialog Title")
            customDialog.show()

            val window: Window? = customDialog.window
            val wlp: WindowManager.LayoutParams = window!!.attributes

            wlp.gravity = Gravity.BOTTOM
            wlp.gravity = Gravity.END
            wlp.flags = wlp.flags and WindowManager.LayoutParams.FLAG_DIM_BEHIND.inv()
            window.attributes = wlp
        }


        binding.fmCount.setOnClickListener {
            Log.d("UpdatedZikr", "incrementTodayAndAllZikr: button clicked")

            viewModelTasbeh.incrementParams()
        }

    }

    private fun setupZikrObservers() {
        lifecycleScope.launch {
            viewModelTasbeh.zikrState.collect{zikrState->
                when(zikrState){
                    is UiStateObject.SUCCESS->{
                        Log.d("ZIKRSTATE", "setupZikrObservers: ${zikrState.data}")
                        showSelectedZikrFields(zikrState.data)
                    }
            }
            }
        }
    }

    // This method is called when an item is clicked in the RecyclerView
//    private fun onZikrSelected(zikr: Zikr) {
        // Set the selected Zikr object in the ViewModel
//        viewModelTasbeh.onZikrSelected(zikr)
//    }

    private fun showSelectedZikrFields(zikr: Zikr) {
        binding.apply {
                tvNowCount.text = zikr.today_zikr
                tvbeforeCount.text = zikr.all_zikr
        }
    }


    override fun onPause() {
        super.onPause()

        Log.d("@@@", "Tasbeh on pause")
    }

    override fun onResume() {
        super.onResume()
        Log.d("@@@", "Tasbeh on resume")
    }

    override fun onStart() {
        super.onStart()

        Log.d("@@@", "Tasbeh on Start")
    }

    override fun onStop() {
        super.onStop()

//        (binding.navView.getHeaderView(0).findViewById<ViewPager2>(R.id.viewpager2).adapter)
        Log.d("@@@", "Tasbeh on stop")
    }
}



class FragmentAdapter @Inject constructor(
    private val drawerLayout: DrawerLayout,
    activity: AppCompatActivity,

) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ZikrScreen( drawerLayout)
            1 -> SalovatScreen(drawerLayout)
            else -> ZikrScreen( drawerLayout)
        }
    }
}
