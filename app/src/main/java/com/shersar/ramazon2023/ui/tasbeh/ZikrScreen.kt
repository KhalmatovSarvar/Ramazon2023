package com.shersar.ramazon2023.ui.tasbeh

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.adapters.CategoriesAdapter
import com.shersar.ramazon2023.databinding.ScreenZikrBinding
import com.shersar.ramazon2023.model.Item
import com.shersar.ramazon2023.model.Zikrlar
import viewBinding

class ZikrScreen : Fragment(R.layout.screen_zikr) {

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
                10,
                "Ma shaa Alloh",
                " سُبْحَانَ اللهِ",
                "“Subhanalloh” so’zi “allohni poklab yod etaman, Allohni poklayman”, deb o’girilgan.",
                "12",
                "1234"
            ),

    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {
        recyclerView = binding.recyclerView
        val adapter = CategoriesAdapter(requireContext(), categories)
        recyclerView.adapter = adapter
    }
}