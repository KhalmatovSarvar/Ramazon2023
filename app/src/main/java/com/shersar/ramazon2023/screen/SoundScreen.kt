package com.shersar.ramazon2023.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.databinding.ScreenHomeBinding
import com.shersar.ramazon2023.databinding.ScreenSoundBinding
import viewBinding


class SoundScreen : Fragment(R.layout.screen_sound) {

    private val binding by viewBinding { ScreenSoundBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {
        binding.ivBack.setOnClickListener {
            findNavController().navigateUp()
        }

    }
}