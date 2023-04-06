package com.shersar.ramazon2023.ui.tasbeh

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.activity.MainActivity
import com.shersar.ramazon2023.adapters.CategoriesAdapter
import com.shersar.ramazon2023.data.local.entity.Zikr
import com.shersar.ramazon2023.databinding.ScreenZikrBinding
import com.shersar.ramazon2023.ui.tasbeh.viewmodel.TasbehViewmodel
import com.shersar.ramazon2023.utils.UiStateList
import com.shersar.ramazon2023.utils.UiStateObject
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import viewBinding
import javax.inject.Inject

@AndroidEntryPoint
class ZikrScreen(
    private val drawerLayout: DrawerLayout
) :
    Fragment(R.layout.screen_zikr) {
    private val categoryAdapter by lazy { CategoriesAdapter() }
    private var list = mutableListOf<Zikr>()
    private val binding by viewBinding { ScreenZikrBinding.bind(it) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity() as MainActivity).viewModel.getAllZikr()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpObservers()
        updateZikrObserver()

        Log.d("RRR", "Drawer OPENED ${drawerLayout.isDrawerOpen(GravityCompat.END)}")
        categoryAdapter.onClick = {

            (requireActivity() as MainActivity).viewModel.apply {
                resetCurrentZikr(it.id)
            }
            drawerLayout.closeDrawer(GravityCompat.END)
//                                (requireActivity() as MainActivity).viewModel.getZikrState()
        }
    }

    private fun updateZikrObserver() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            (requireActivity() as MainActivity).viewModel.zikrState.collect { zikr ->
                when (zikr) {
                    is UiStateObject.SUCCESS -> {
                        list.find { it.id == zikr.data.id }?.let { zikr2 ->
                            val updatedZikr = zikr2.copy(
                                id = zikr.data.id,
                                current_zikr =zikr.data.current_zikr ,
                                today_zikr = zikr.data.today_zikr,
                                all_zikr = zikr.data.all_zikr

                            )
                            list[list.indexOf(zikr2)] = updatedZikr
                            Log.d("ZIKRSCREEN", "updateZikrObserver: $updatedZikr")
                            categoryAdapter.submitData(list)
                        }
                        binding.recyclerView.adapter = categoryAdapter
                    }
                }
            }
        }
    }


    private fun setUpObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                (requireActivity() as MainActivity).viewModel.zikrListState.collect {
                    when (it) {
                        is UiStateList.LOADING -> {

                        }
                        is UiStateList.SUCCESS -> {
                            list.addAll(it.data)
                            categoryAdapter.submitData(list)

                            binding.recyclerView.adapter = categoryAdapter
                        }
                        is UiStateList.ERROR -> {
                        }
                        else -> Unit
                    }

                }


            }
        }

    }

}


