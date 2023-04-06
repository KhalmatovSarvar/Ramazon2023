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
import com.shersar.ramazon2023.data.local.entity.Zikr
import com.shersar.ramazon2023.databinding.ScreenItem1Binding
import com.shersar.ramazon2023.ui.tasbeh.viewmodel.TasbehViewmodel
import com.shersar.ramazon2023.utils.UiStateObject
import com.shersar.ramazon2023.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import viewBinding
import javax.inject.Inject
@AndroidEntryPoint
class Item1Screen @Inject constructor(
) : Fragment(R.layout.screen_item1) {
    private var itemText: String? = null
    private val binding by viewBinding { ScreenItem1Binding.bind(it) }


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        (requireActivity() as MainActivity).viewModel.getZikrState()
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpObservers()

//        Log.d("@@@@", "Item 1 Screen ${(requireActivity() as MainActivity).viewModel._homeState.value.uzb_zikr}")

    }


    private fun setUpObservers() {
        lifecycleScope.launch {
            (requireActivity() as MainActivity).viewModel.zikrState.collect { zikr ->
                when(zikr) {
                    is UiStateObject.SUCCESS ->{
                        binding.apply {
                            Log.d("ITEM1SCREEN", "setUpObservers: ${zikr.data}")

                            tvUzb.text = zikr.data.uzb_zikr
                            tvArab.text = zikr.data.arab_zikr
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