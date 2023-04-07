package com.shersar.ramazon2023.ui.settings

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.databinding.ScreenAboutProjectBinding
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
        binding.llHelpService.setOnClickListener {
            Toast(requireContext()).showCustomToast(
                R.drawable.ic_question,
                "Tez kunda!",
                requireActivity()
            )
        }
        binding.llStart.setOnClickListener {
            Toast(requireContext()).showCustomToast(
                R.drawable.ic_startt,
                "Tez kunda!",
                requireActivity()
            )
        }
    }
    fun Toast.showCustomToast(imageView: Int, message: String, activity: Activity) {
        val layout = activity.layoutInflater.inflate(
            R.layout.custom_toast,
            activity.findViewById(R.id.custom_toast)
        )

        // set the text of the TextView of the message
        val textView = layout.findViewById<TextView>(R.id.tv_toast)
        textView.text = message

        val img = layout.findViewById<ImageView>(R.id.iv_toast)
        img.setImageResource(imageView)


        // use the application extension function
        this.apply {
            setGravity(Gravity.BOTTOM, 0, 330)
            duration = Toast.LENGTH_SHORT
            view = layout
            show()
        }
    }
}