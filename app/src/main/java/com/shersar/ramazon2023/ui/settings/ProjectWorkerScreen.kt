package com.shersar.ramazon2023.ui.settings

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.databinding.ScreenInAboutProjectBinding
import com.shersar.ramazon2023.databinding.ScreenProjectWorkerBinding
import viewBinding

class ProjectWorkerScreen : Fragment(R.layout.screen_project_worker) {

    private val binding by viewBinding { ScreenProjectWorkerBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {

        binding.ivBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.ivTelegGuli.setOnClickListener {
            val telegram = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/zikr_va_d"))
            telegram.setPackage("org.telegram.messenger")
            startActivity(telegram)
        }
    }
}