package com.shersar.ramazon2023.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.databinding.ScreenItem2Binding
import viewBinding

class Item2Screen : Fragment(R.layout.screen_item2) {

    private val binding by viewBinding { ScreenItem2Binding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {

    }

    companion object {
        fun newInstance()=Item2Screen()
    }
}