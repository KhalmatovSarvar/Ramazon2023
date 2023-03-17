package com.shersar.ramazon2023.ui.tasbeh

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.adapters.CategoriesAdapter
import com.shersar.ramazon2023.databinding.ScreenZikrBinding
import com.shersar.ramazon2023.model.Item
import com.shersar.ramazon2023.model.Zikrlar
import com.shersar.ramazon2023.ui.tasbeh.viewmodel.ZikrViewModel
import viewBinding

class ZikrScreen(val viewModel: ZikrViewModel, val drawerLayout: DrawerLayout) :
    Fragment(R.layout.screen_zikr) {

    private lateinit var recyclerView: RecyclerView

    private val binding by viewBinding { ScreenZikrBinding.bind(it) }
    private val categories = mutableListOf(

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
        ),

        )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {
        recyclerView = binding.recyclerView
        val adapter = CategoriesAdapter(requireContext(), categories)

        adapter.onClick = {
            viewModel._homeState.value = it
            viewModel.setZikrState(it)
            Log.d("@@@", "Here -> ${it.uzb_zikr} : ")
            drawerLayout.closeDrawer(GravityCompat.END)
            viewModel.getZikrState()
        }
        recyclerView.adapter = adapter
    }
}