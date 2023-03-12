package com.shersar.ramazon2023.ui.tasbeh

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.databinding.ScreenItem1Binding
import com.shersar.ramazon2023.model.Item
import viewBinding

class Item1Screen : Fragment(R.layout.screen_item1) {
    private var itemText: String? = null
    private val binding by viewBinding { ScreenItem1Binding.bind(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {
        val uzbZikr = binding.tvUzb
    }

    companion object {
        fun newInstance(){}
    }
}