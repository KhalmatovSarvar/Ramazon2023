package com.shersar.ramazon2023.ui.settings

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.databinding.ScreenAboutProjectBinding
import com.shersar.ramazon2023.databinding.ScreenHomeBinding
import com.shersar.ramazon2023.databinding.ScreenSoundBinding
import viewBinding


class AboutProjectScreen : Fragment(R.layout.screen_about_project) {

    private val binding by viewBinding { ScreenAboutProjectBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {

        binding.ivBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.llAboutProject.setOnClickListener {
            findNavController().navigate(R.id.inAboutProjectScreen)
        }
        binding.llShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.shersar.ramazon2023")
            startActivity(Intent.createChooser(shareIntent, "Ulashing..."))
        }
    }
}