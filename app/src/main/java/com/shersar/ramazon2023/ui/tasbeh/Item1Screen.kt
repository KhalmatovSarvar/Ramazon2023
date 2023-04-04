package com.shersar.ramazon2023.ui.tasbeh

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.databinding.ScreenItem1Binding
import com.shersar.ramazon2023.model.Item
import com.shersar.ramazon2023.ui.tasbeh.viewmodel.SalovatViewModel
import com.shersar.ramazon2023.ui.tasbeh.viewmodel.ZikrViewModel
import viewBinding

class Item1Screen(private val viewModel: ZikrViewModel) : Fragment(R.layout.screen_item1) {
    private var itemText: String? = null
    private val binding by viewBinding { ScreenItem1Binding.bind(it) }

    companion object {
        fun newInstance(item: Item){}
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        Log.d("@@@@", "Item 1 Screen ${viewModel._homeState.value.uzb_zikr}")

    }

    private fun initView() {
        binding.apply {
            tvUzb.text = viewModel._homeState.value.uzb_zikr
            tvArab.text = viewModel._homeState.value.arab_zikr
        }
    }

}