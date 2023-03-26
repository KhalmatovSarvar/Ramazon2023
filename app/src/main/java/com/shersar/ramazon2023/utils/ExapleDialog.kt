package com.shersar.ramazon2023.utils

import android.app.AlertDialog
import android.app.Dialog
import android.content.res.ColorStateList
import android.os.Bundle
import android.widget.Switch
import androidx.fragment.app.DialogFragment
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.databinding.ItemMoreBinding

class ExapleDialog : DialogFragment() {
    private lateinit var binding : ItemMoreBinding
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Create a new AlertDialog and inflate its layout
        val builder = AlertDialog.Builder(activity)
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.item_more, null)
        builder.setView(view)
       /* binding.switchCompatVib.setOnCheckedChangeListener { _, isChecked ->
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
        }*/
//
//            // Check the switch's value and perform your logic
//            if (binding.switchCompatVib.isChecked) {
//                // Do something when the switch is on
//                binding.switchCompatVib.thumbTintList =
//                    ColorStateList.valueOf(resources.getColor(R.color.background))
//                binding.switchCompatVib.trackTintList =
//                    ColorStateList.valueOf(resources.getColor(R.color.for_switch_true))
//            } else {
//                // Do something when the switch is off
//                binding.switchCompatVib.thumbTintList =
//                    ColorStateList.valueOf(resources.getColor(R.color.card_background_day))
//                binding.switchCompatVib.trackTintList =
//                    ColorStateList.valueOf(resources.getColor(R.color.for_switch_false))
//            }


        return builder.create()
    }
}