package com.shersar.ramazon2023.ui.tasbeh

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.activity.MainActivity
import com.shersar.ramazon2023.databinding.ScreenItem2Binding
import com.shersar.ramazon2023.ui.tasbeh.viewmodel.TasbehViewmodel
import com.shersar.ramazon2023.utils.UiStateObject
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.screen_item2.*
import kotlinx.coroutines.launch
import viewBinding
@AndroidEntryPoint
class Item2Screen() : Fragment(R.layout.screen_item2) {
    private val binding by viewBinding { ScreenItem2Binding.bind(it) }

    companion object {
//        fun newInstance(item: Item)= Item2Screen(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        setUpObservers()

    }

    private fun initView() {

    }

    private fun setUpObservers() {
        lifecycleScope.launch {
            (requireActivity() as MainActivity).viewModel.zikrState.collect { zikr ->
                when(zikr) {
                    is UiStateObject.SUCCESS ->{
                        binding.apply {
                            Log.d("ITEM2SCREEN", "setUpObservers: ${zikr.data}")

                            tv_tarjima.text = zikr.data.tarjima
                        }
                    }
                    is UiStateObject.ERROR -> {
                        // Handle error
                        val errorMessage = zikr.message
                        Log.d("HOMESCREEN", "setUpObserversError: $errorMessage ")
//                        Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
                    }
                    UiStateObject.LOADING -> {
                        // Show loading indicator
//                        Toast.makeText(requireContext(), "LOADING", Toast.LENGTH_SHORT).show()
                    }
                    UiStateObject.EMPTY -> {
                        // Handle empty state
                    }

                }
            }
        }
    }

}