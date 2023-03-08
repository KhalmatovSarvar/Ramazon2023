package com.shersar.ramazon2023.screen.tasbeh

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.ahmadhamwi.tabsync.TabbedListMediator
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.adapters.CategoriesAdapter
import com.shersar.ramazon2023.databinding.ScreenTasbehBinding
import com.shersar.ramazon2023.model.Item
import com.shersar.ramazon2023.model.Zikrlar
import com.shersar.ramazon2023.screen.Item1Screen
import com.shersar.ramazon2023.screen.Item2Screen
import me.relex.circleindicator.CircleIndicator3
import viewBinding


class TasbehScreen : Fragment(R.layout.screen_tasbeh) {
    private lateinit var tabLayout: TabLayout
    private lateinit var recyclerView: RecyclerView
    private val binding by viewBinding { ScreenTasbehBinding.bind(it) }

    private val categories = mutableListOf(
        Zikrlar(
            "Zikrlar",
            Item(
                1,
                "Subhanalloh",
                " سُبْحَانَ اللهِ",
                "“Subhanalloh” so’zi “allohni poklab yod etaman, Allohni poklayman”, deb o’girilgan.",
                "10",
                "255"
            ),
            Item(
                2,
                "Ma shaa Alloh",
                " سُبْحَانَ اللهِ",
                "“Subhanalloh” so’zi “allohni poklab yod etaman, Allohni poklayman”, deb o’girilgan.",
                "12",
                "1234"
            ),
            Item(
                1,
                "Subhanalloh",
                " سُبْحَانَ اللهِ",
                "“Subhanalloh” so’zi “allohni poklab yod etaman, Allohni poklayman”, deb o’girilgan.",
                "10",
                "255"
            ),
            Item(
                1,
                "Subhanalloh",
                " سُبْحَانَ اللهِ",
                "“Subhanalloh” so’zi “allohni poklab yod etaman, Allohni poklayman”, deb o’girilgan.",
                "10",
                "255"
            ),
            Item(
                1,
                "Subhanalloh",
                " سُبْحَانَ اللهِ",
                "“Subhanalloh” so’zi “allohni poklab yod etaman, Allohni poklayman”, deb o’girilgan.",
                "10",
                "255"
            ),
            Item(
                1,
                "Subhanalloh",
                " سُبْحَانَ اللهِ",
                "“Subhanalloh” so’zi “allohni poklab yod etaman, Allohni poklayman”, deb o’girilgan.",
                "10",
                "255"
            )
        ),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /** initView()
        initViews()
        initTabLayout()
        initRecycler()
        initMediator()
        viewPager()*/
        initview()
        initViewPager()
    }

    private fun initViewPager() {
        var viewPagerr: ViewPager2 = binding.viewpager2
        var circleIndicator: CircleIndicator3 = binding.circleIndicator
        val adapter = ViewPagerAdapter(requireActivity())
        viewPagerr.adapter = adapter

        // Set the CircleIndicator with ViewPager2
        circleIndicator.setViewPager(viewPagerr)
    }

    private fun initview() {
        val header: View
        binding.ivVerMore.setOnClickListener {
            binding.drawerlayout.openDrawer(GravityCompat.END)
        }
        binding.apply {
            header = navView.getHeaderView(0)
        }
        initTabs(header)

    }

    private fun initTabs(header: View){

        val viewPager2: ViewPager2 = header.findViewById(R.id.viewpager2)
        val tabLayout: TabLayout = header.findViewById(R.id.tabLayout)

        viewPager2.adapter = FragmentAdapter(requireContext() as AppCompatActivity)
        viewPager2.isUserInputEnabled = false
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when(position){
                0 -> tab.text = "Zikrlar"
                1 -> tab.text = "Salovatlar"
                else -> tab.text = "Salovatlar"
            }
        }.attach()
    }


/*
    private fun initTabLayout() {
        for (category in categories) {
            tabLayout.addTab(tabLayout.newTab().setText(category.name))
        }
    }

    private fun initRecycler() {
        recyclerView.adapter = CategoriesAdapter(requireContext(), categories[0].listOfItems)
    }

    private fun initMediator() {
        TabbedListMediator(
            recyclerView,
            tabLayout,
            categories.indices.toList()
        ).attach()
    }

    private fun viewPager() {
        binding.viewpager2.adapter = FragmentAdapter(requireContext() as AppCompatActivity)
    }
    */
}
class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    private val fragments = listOf(Item1Screen(), Item2Screen())

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}


class FragmentAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ZikrScreen()
            1 -> SalovatScreen()
            else -> ZikrScreen()
        }
    }
}
