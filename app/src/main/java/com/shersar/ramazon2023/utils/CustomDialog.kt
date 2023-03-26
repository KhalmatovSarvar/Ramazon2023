package com.shersar.ramazon2023.utils

import android.app.Dialog
import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.databinding.ItemMoreBinding


class CustomDialog(context: Context) : Dialog(context) {

    private lateinit var binding :ItemMoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ItemMoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
  }

    private fun initView() {
        //  val sharedPreferences: SharedPreferences = requireContext().getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
//        binding.switchCompatVib.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked) {
//                binding.switchCompatVib.thumbTintList =
//                    ColorStateList.valueOf(resources.getColor(R.color.background))
//                binding.switchCompatVib.trackTintList =
//                    ColorStateList.valueOf(resources.getColor(R.color.for_switch_true))
//                // val switchState = sharedPreferences.getBoolean("switch_state", true)
//                // switch_compat_vib.isChecked = switchState
//            } else {
//                binding.switchCompatVib.thumbTintList =
//                    ColorStateList.valueOf(resources.getColor(R.color.card_background_day))
//                binding.switchCompatVib.trackTintList =
//                    ColorStateList.valueOf(resources.getColor(R.color.for_switch_false))
//                //val switchState = sharedPreferences.getBoolean("switch_state", false)
//                // switch_compat_vib.isChecked = switchState
//            }
//        }
    }

}