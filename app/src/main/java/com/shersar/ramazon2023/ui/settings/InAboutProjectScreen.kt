package com.shersar.ramazon2023.ui.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.databinding.ScreenInAboutProjectBinding
import viewBinding

class InAboutProjectScreen : Fragment(R.layout.screen_in_about_project) {

    private val binding by viewBinding { ScreenInAboutProjectBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {

        binding.ivBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.llBeginner.setOnClickListener {
            findNavController().navigate(R.id.projectWorkerScreen)
        }
    }
}