package com.shersar.ramazon2023.ui.tasbeh

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.databinding.ScreenSalovatBinding
import com.shersar.ramazon2023.ui.tasbeh.viewmodel.ZikrViewModel
import viewBinding

class SalovatScreen(val viewModel: ZikrViewModel) :Fragment(R.layout.screen_salovat){

    private val binding by viewBinding { ScreenSalovatBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {

    }
}