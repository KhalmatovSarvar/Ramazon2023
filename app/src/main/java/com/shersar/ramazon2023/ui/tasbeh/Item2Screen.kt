package com.shersar.ramazon2023.ui.tasbeh

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.databinding.ScreenItem2Binding
import com.shersar.ramazon2023.ui.tasbeh.viewmodel.TasbehViewmodel
import dagger.hilt.android.AndroidEntryPoint
import viewBinding
@AndroidEntryPoint
class Item2Screen() : Fragment(R.layout.screen_item2) {
    private val tasbehViewmodel: TasbehViewmodel by activityViewModels()
    private val binding by viewBinding { ScreenItem2Binding.bind(it) }

    companion object {
//        fun newInstance(item: Item)= Item2Screen(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {

//        Log.d("@@@@", "Item 2 Screen ${viewModel._homeState.value.arab_zikr}")

        binding.tvTarjima.text = tasbehViewmodel._selectedZikr.value.tarjima
    }

}