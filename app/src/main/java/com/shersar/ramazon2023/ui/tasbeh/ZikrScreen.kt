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
import com.shersar.ramazon2023.adapters.CategoriesAdapter
import com.shersar.ramazon2023.data.local.entity.Zikr
import com.shersar.ramazon2023.databinding.ScreenZikrBinding
import com.shersar.ramazon2023.ui.tasbeh.viewmodel.TasbehViewmodel
import com.shersar.ramazon2023.utils.UiStateList
import com.shersar.ramazon2023.utils.UiStateObject
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import viewBinding
import javax.inject.Inject

@AndroidEntryPoint
class ZikrScreen @Inject constructor(
    private val drawerLayout: DrawerLayout
) :
    Fragment(R.layout.screen_zikr) {
    private val tasbehViewmodel: TasbehViewmodel by activityViewModels()
    private val adapter by lazy { CategoriesAdapter() }
    private var list = mutableListOf<Zikr>()
    private val binding by viewBinding { ScreenZikrBinding.bind(it) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            recyclerView.adapter = adapter
        }

        setUpObservers()
        updateZikrObservers()
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "onResume: ok")
        tasbehViewmodel.getAllZikr()
    }

     private fun updateZikrObservers(){
         viewLifecycleOwner.lifecycleScope.launch{
             repeatOnLifecycle(Lifecycle.State.STARTED){
                 tasbehViewmodel.zikrState.collect{zikr ->
                    when(zikr){
                        is UiStateObject.SUCCESS -> {
                            list.firstOrNull {it == zikr.data}?.let { zikr2 ->
                                val updatedZikr = zikr2.copy(
                                    id = zikr2.id,
                                    today_zikr = zikr2.today_zikr
                                )
                                list[list.indexOf(zikr2)] = updatedZikr
                                adapter.submitData(list)
                            }
                        }
                    }
                 }
             }
         }
     }

    private fun setUpObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                tasbehViewmodel.zikrListState.collect {
                    when (it) {
                        is UiStateList.LOADING -> {

                        }
                        is UiStateList.SUCCESS -> {
                            list.addAll(it.data)
                            adapter.submitData(list)
                            adapter.onClick = {
                            Log.d("ZIKRSCREEN", "${it.today_zikr.toString()}")
                                tasbehViewmodel.setZikrState(it)
                                Log.d("ZIKRSCREEN", "CODE reached here: ")
                                drawerLayout.closeDrawer(GravityCompat.END)
//                                tasbehViewmodel.getZikrState()
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


