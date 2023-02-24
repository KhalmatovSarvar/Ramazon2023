package com.shersar.ramazon2023.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.databinding.ScreenHomeBinding
import viewBinding

class HomeScreen: Fragment(R.layout.screen_home) {

    private val binding by viewBinding { ScreenHomeBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        //hghgghg
    }

    private fun initView() {


    }
}