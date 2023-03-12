package com.shersar.ramazon2023.ui.tasbeh

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.databinding.ScreenTasbehBinding
import com.shersar.ramazon2023.model.Item
import com.shersar.ramazon2023.model.Zikrlar
import com.shersar.ramazon2023.utils.CustomDialog
import me.relex.circleindicator.CircleIndicator3
import viewBinding


class TasbehScreen : Fragment(R.layout.screen_tasbeh) {
    private lateinit var tabLayout: TabLayout
    private lateinit var recyclerView: RecyclerView
    private val binding by viewBinding { ScreenTasbehBinding.bind(it) }
    var count = 0
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

        initview()
        initViewPager()
        initCounts()
    }

    private fun initCounts() {

        binding.ivMoreVerDot.setOnClickListener {
            Toast.makeText(requireContext(), "sssssss", Toast.LENGTH_SHORT).show()
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
        binding.fitCount.setOnClickListener {
            count++
            binding.tvNowCount.text = count.toString()
            binding.tvbeforeCount.text = count.toString()
        }
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

    private fun initTabs(header: View) {

        val viewPager2: ViewPager2 = header.findViewById(R.id.viewpager2)
        val tabLayout: TabLayout = header.findViewById(R.id.tabLayout)

        viewPager2.adapter = FragmentAdapter(requireContext() as AppCompatActivity)
        viewPager2.isUserInputEnabled = false
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> tab.text = "Zikrlar"
                1 -> tab.text = "Salovatlar"
                else -> tab.text = "Salovatlar"
            }
        }.attach()


    }


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
