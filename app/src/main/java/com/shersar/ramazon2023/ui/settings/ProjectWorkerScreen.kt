package com.shersar.ramazon2023.ui.settings

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
            val tgIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/zikr_va_d"))
            tgIntent.`package` = "org.telegram.messenger"
            try {
                startActivity(tgIntent)
            } catch (e: ActivityNotFoundException) {
                // Telegram is not installed on the device, show an error message to the user
                Toast.makeText(requireContext(), "Telegram is not installed on your device", Toast.LENGTH_SHORT).show()
            }
        }
        binding.ivTelegHilola.setOnClickListener {
            val tgIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/ilmdan_najot"))
            tgIntent.`package` = "org.telegram.messenger"
            try {

                startActivity(tgIntent)
            } catch (e: ActivityNotFoundException) {
                // Telegram is not installed on the device, show an error message to the user
                Toast.makeText(requireContext(), "Telegram is not installed on your device", Toast.LENGTH_SHORT).show()
            }
        }
    }
}