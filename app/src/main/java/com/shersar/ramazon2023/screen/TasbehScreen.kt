package com.shersar.ramazon2023.screen

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.ahmadhamwi.tabsync.TabbedListMediator
import com.google.android.material.tabs.TabLayout
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.adapters.CategoriesAdapter
import com.shersar.ramazon2023.databinding.ActivityMainBinding
import com.shersar.ramazon2023.databinding.ScreenTasbehBinding
import com.shersar.ramazon2023.model.Category
import com.shersar.ramazon2023.model.Item
import viewBinding


class TasbehScreen : Fragment(R.layout.screen_tasbeh) {
    private lateinit var tabLayout: TabLayout
    private lateinit var recyclerView: RecyclerView
    private val binding by viewBinding { ScreenTasbehBinding.bind(it) }

    //    val drawer = binding.drawerCustom
    private val categories = mutableListOf(
        Category(
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
        Category(
            "Salovatlar",
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
        Category(
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
        Category(
            "Kalimlar",
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
        Category(
            "40 hadis",
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

        initView()
        initViews()
        initTabLayout()
        initRecycler()
        initMediator()
    }

    private fun initView() {
        var count1 = 1
        var count2 = 1
        binding.constraintLayout.setOnClickListener {
            binding.moreSettings.root.visibility = View.GONE
            binding.drawerCustom.root.visibility = View.GONE
        }
        binding.icMore.setOnClickListener {
            binding.moreSettings.root.visibility = View.VISIBLE
        }
        binding.drawerr.setOnClickListener {
            binding.drawerCustom.root.visibility = View.VISIBLE
        }

        val image = binding.moreSettings

        image.ivGoneVibratsiya.setOnClickListener {
            if (count1 % 2 != 0) {
                image.ivGoneVibratsiya.setImageResource(R.drawable.ic_visib)
                count1++
            } else {
                image.ivGoneVibratsiya.setImageResource(R.drawable.ic_gone)
                count1++
            }
        }
        image.ivVisibleOvoz.setOnClickListener {
            if (count2 % 2 != 0) {
                image.ivVisibleOvoz.setImageResource(R.drawable.ic_visib)
                count2++
            } else {
                image.ivVisibleOvoz.setImageResource(R.drawable.ic_gone)
                count2++
            }
        }
        image.tvUrta.setOnClickListener {
            image.tvUrta.setBackgroundResource(R.drawable.bg_middle)
            image.tvKatta.setBackgroundResource(R.color.white)
            image.tvUrta.setTextColor(Color.parseColor("#FFFFFF"))
            image.tvKatta.setTextColor(Color.parseColor("#263238"))
        }

        image.tvKatta.setOnClickListener {
            image.tvKatta.setBackgroundResource(R.drawable.bg_middle)
            image.tvUrta.setBackgroundResource(R.color.white)
            image.tvKatta.setTextColor(Color.parseColor("#FFFFFF"))
            image.tvUrta.setTextColor(Color.parseColor("#263238"))
        }


    }

    private fun initViews() {

        tabLayout = binding.drawerCustom.tabLayout
        recyclerView = binding.drawerCustom.recyclerView
    }

    private fun initTabLayout() {
        for (category in categories) {
            tabLayout.addTab(tabLayout.newTab().setText(category.name))
        }
    }

    private fun initRecycler() {
        recyclerView.adapter = CategoriesAdapter(requireContext(), categories)
    }

    private fun initMediator() {
        TabbedListMediator(
            recyclerView,
            tabLayout,
            categories.indices.toList()
        ).attach()
    }
}