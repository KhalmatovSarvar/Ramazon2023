package com.shersar.ramazon2023.ui.settings

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.adapters.BottomSheetAdapter
import com.shersar.ramazon2023.databinding.ScreenSettingsBinding
import com.shersar.ramazon2023.model.Bottomsheet
import com.shersar.ramazon2023.model.Location
import com.shersar.ramazon2023.utils.activityNavController
import com.shersar.ramazon2023.utils.navigateSafely
import viewBinding


class SettingsScreen : Fragment(R.layout.screen_settings) {
    private lateinit var adapter: BottomSheetAdapter
    private lateinit var recyclerView: RecyclerView
    private var list = arrayListOf<Bottomsheet>()
    private var data =
        arrayOf(
            Location("Toshkent", 41.2842, 69.2441),
            Location("Andijon", 40.7814, 72.3578),
            Location("Namangan", 41.0522, 71.6465),
            Location("Farg'ona", 40.3694, 71.7989),
            Location("Jizzax", 40.1214, 67.9031),
            Location("Sirdaryo", 40.8346, 68.6783),
            Location("Samarqand", 39.7483, 66.8888),
            Location("Qashqadaryo", 38.8555, 65.7783),
            Location("Surxondaryo", 37.2880, 67.3164),
            Location("Navoiy", 40.1012, 65.3885),
            Location("Xiva", 41.3906, 60.3481),
            Location("Urganch", 41.5352, 60.6313),
            Location("Buxoro", 39.7669, 64.4587)
        )
    private val binding by viewBinding { ScreenSettingsBinding.bind(it) }
    private lateinit var bottomSheet1: BottomSheetDialog
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()


    }

    private fun initView() {
        binding.llSoundNot.setOnClickListener {
            findNavController().navigate(R.id.soundScreen)
        }
        binding.llLocation.setOnClickListener {
            activityNavController().navigateSafely(R.id.action_mainFlowFragment_to_locationScreen)
        }
        binding.llAboutProject.setOnClickListener {
            findNavController().navigate(R.id.aboutProjectScreen)
        }
    }

    private fun bottomSheet() {
        val bottomSheet = layoutInflater.inflate(R.layout.bottomsheet, null)
        bottomSheet1 = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
        bottomSheet1.setContentView(bottomSheet)
        recyclerView = bottomSheet.findViewById(R.id.rv)
        adapter = BottomSheetAdapter(getData())
        recyclerView.adapter = adapter
        bottomSheet1.show()
        var count = 1
        bottomSheet.findViewById<LinearLayout>(R.id.choose).setOnClickListener {
            if (count % 2 == 1) {
                bottomSheet.findViewById<ImageView>(R.id.arrow_down)
                    .setImageResource(R.drawable.ic_up_arrow)
                bottomSheet.findViewById<RecyclerView>(R.id.rv).visibility = View.VISIBLE
                count++
            } else {
                bottomSheet.findViewById<ImageView>(R.id.arrow_down)
                    .setImageResource(R.drawable.ic_arrow_down)
                bottomSheet.findViewById<RecyclerView>(R.id.rv).visibility = View.GONE
                count++
            }
        }
    }

    private fun getData(): ArrayList<Bottomsheet> {
        for (i in data.indices) {
            list.add(Bottomsheet(data[i], false))
        }
        return list
    }
}
