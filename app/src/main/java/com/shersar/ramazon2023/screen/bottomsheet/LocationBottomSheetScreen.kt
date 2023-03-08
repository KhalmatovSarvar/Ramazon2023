package com.shersar.ramazon2023.screen.bottomsheet

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.shersar.ramazon2023.databinding.BottomsheetBinding

class LocationBottomSheetScreen:BottomSheetDialogFragment() {

    private lateinit var binding:BottomsheetBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {

    }
}