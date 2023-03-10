package com.shersar.ramazon2023.utils

import android.app.Dialog
import android.content.Context
import android.os.Bundle
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

    }

}