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
import viewBinding


class SettingsScreen : Fragment(R.layout.screen_settings) {
    private lateinit var adapter: BottomSheetAdapter
    private lateinit var recyclerView: RecyclerView
    private var list = arrayListOf<Bottomsheet>()
    private var data =
        arrayOf("Toshkent", "Andijon", "Namangan", "Xorazm", "Navoiy", "Bekobod", "Jizzax")
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
            bottomSheet()
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
                bottomSheet.findViewById<ImageView>(R.id.arrow_down).setImageResource(R.drawable.ic_up_arrow)
                bottomSheet.findViewById<RecyclerView>(R.id.rv).visibility = View.VISIBLE
                count++
            }else{
                bottomSheet.findViewById<ImageView>(R.id.arrow_down).setImageResource(R.drawable.ic_arrow_down)
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
