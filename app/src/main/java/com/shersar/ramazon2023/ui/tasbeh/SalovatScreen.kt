package com.shersar.ramazon2023.ui.tasbeh

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.activity.MainActivity
import com.shersar.ramazon2023.adapters.CategoriesAdapter
import com.shersar.ramazon2023.data.local.entity.Zikr
import com.shersar.ramazon2023.databinding.ScreenSalovatBinding
import com.shersar.ramazon2023.ui.tasbeh.viewmodel.TasbehViewmodel
import com.shersar.ramazon2023.utils.UiStateList
import com.shersar.ramazon2023.utils.UiStateObject
import kotlinx.coroutines.launch
import viewBinding
import javax.inject.Inject

class SalovatScreen@Inject constructor(
    private val drawerLayout: DrawerLayout
) :
    Fragment(R.layout.screen_salovat) {
    private val adapter by lazy { CategoriesAdapter() }
    private val binding by viewBinding { ScreenSalovatBinding.bind(it) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            recyclerView.adapter = adapter
        }

        (requireActivity() as MainActivity).viewModel.getAllZikr()
        setUpObservers()
      //  updateZikrObservers()
    }


    private fun setUpObservers() {

            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    (requireActivity() as MainActivity).viewModel.zikrListState.collect {
                        when (it) {
                            is UiStateList.LOADING -> {

                            }
                            is UiStateList.SUCCESS -> {
                                adapter.submitData( it.data)
                                adapter.onClick = {
                                    (requireActivity() as MainActivity).viewModel.setZikrState(it)
                                    Log.d("@@@", "Here -> ${it.uzb_zikr} : ")
                                    drawerLayout.closeDrawer(GravityCompat.END)
//                                (requireActivity() as MainActivity).viewModel.getZikrState()
                                }

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