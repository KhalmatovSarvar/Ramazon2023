package com.shersar.ramazon2023.ui.settings

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shersar.ramazon2023.R
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
        //  val sharedPreferences: SharedPreferences = requireContext().getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        binding.switchCompatVib.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.switchCompatVib.thumbTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.background))
                binding.switchCompatVib.trackTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.for_switch_true))
                // val switchState = sharedPreferences.getBoolean("switch_state", true)
                // switch_compat_vib.isChecked = switchState
            } else {
                binding.switchCompatVib.thumbTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.card_background_day))
                binding.switchCompatVib.trackTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.for_switch_false))
                //val switchState = sharedPreferences.getBoolean("switch_state", false)
                // switch_compat_vib.isChecked = switchState
            }
        }
        binding.switchCompatNotific.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.switchCompatNotific.thumbTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.background))
                binding.switchCompatNotific.trackTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.for_switch_true))
            } else {
                binding.switchCompatNotific.thumbTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.card_background_day))
                binding.switchCompatNotific.trackTintList =
                    ColorStateList.valueOf(resources.getColor(R.color.for_switch_false))
            }
        }

        // Save switch state in shared preferences
        val sharedPreferences: SharedPreferences =
            requireContext().getSharedPreferences("save", MODE_PRIVATE)
        //vibration
        binding.switchCompatVib.isChecked = sharedPreferences.getBoolean("value", true)
        binding.switchCompatVib.setOnClickListener(View.OnClickListener {
            if (binding.switchCompatVib.isChecked) {
                // When switch checked
                val editor: SharedPreferences.Editor =
                    requireContext().getSharedPreferences("save", MODE_PRIVATE).edit()
                editor.putBoolean("value", true)
                editor.apply()
                binding.switchCompatVib.isChecked = true
            } else {
                // When switch unchecked
                val editor: SharedPreferences.Editor =
                    requireContext().getSharedPreferences("save", MODE_PRIVATE).edit()
                editor.putBoolean("value", false)
                editor.apply()
                binding.switchCompatVib.isChecked = false
            }
        })
        //notification
        binding.switchCompatNotific.isChecked = sharedPreferences.getBoolean("value", true)
        binding.switchCompatNotific.setOnClickListener(View.OnClickListener {
            if (binding.switchCompatNotific.isChecked) {
                // When switch checked
                val editor: SharedPreferences.Editor =
                    requireContext().getSharedPreferences("save", MODE_PRIVATE).edit()
                editor.putBoolean("value", true)
                editor.apply()
                binding.switchCompatNotific.isChecked = true
            } else {
                // When switch unchecked
                val editor: SharedPreferences.Editor =
                    requireContext().getSharedPreferences("save", MODE_PRIVATE).edit()
                editor.putBoolean("value", false)
                editor.apply()
                binding.switchCompatNotific.isChecked = false
            }
        })
    }
}