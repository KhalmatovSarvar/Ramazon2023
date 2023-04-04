package com.shersar.ramazon2023.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.data.local.entity.Zikr
import com.shersar.ramazon2023.ui.tasbeh.Item1Screen
import com.shersar.ramazon2023.ui.tasbeh.viewmodel.TasbehViewmodel
import javax.inject.Inject

class CategoriesAdapter (
) : RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {

    private val dif = AsyncListDiffer(this, ITEM_DIF)
    var onClick: ((Zikr) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_drawer_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
         holder.bind(dif.currentList[position])
        val Items = dif.currentList[position]
        holder.uzb.text = Items.uzb_zikr
        holder.arab.text = Items.arab_zikr
        holder.tarjima.text = Items.tarjima
        holder.todayZikr.text = Items.today_zikr.toString()
        holder.allZikr.text = Items.all_zikr
        holder.orderNumber.text = (Items.id).toString()
        holder.bind(Items)
        holder.itemView.setOnClickListener {
            onClick?.invoke(dif.currentList[position])

//            val fragment = Item1Screen.newInstance(list[position])
//            (holder.itemView.context as AppCompatActivity).supportFragmentManager
//                .beginTransaction()
//                .replace(R.id, fragment)
//                .addToBackStack(null)
//                .commit()
        }
    }

    override fun getItemCount(): Int =  dif.currentList.size

    fun submitData(list: List<Zikr>) {
        dif.submitList(list)
        Log.d("DIFLIST", "submitData: ${list[1].today_zikr}")
    }

    inner class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val uzb: TextView = view.findViewById(R.id.tv_name_zikr_uzb)
        val arab: TextView = view.findViewById(R.id.tv_name_zikr_arab)
        val tarjima: TextView = view.findViewById(R.id.tv_tarjima)
        val allZikr: TextView = view.findViewById(R.id.tv_all_zikr)
        val todayZikr: TextView = view.findViewById(R.id.tv_today_zikr)
        val orderNumber: TextView = view.findViewById(R.id.tv_number_order)
        fun bind(zikr: Zikr) {
            itemView.setOnClickListener {
                Log.d("CategoriesAdapter", "bind: ONCLICK  ${zikr.toString()}")
                onClick?.invoke(zikr)
            }
        }

    }

    companion object {
        private val ITEM_DIF = object : DiffUtil.ItemCallback<Zikr>() {

            override fun areItemsTheSame(
                oldItem: Zikr,
                newItem: Zikr
            ): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(
                oldItem: Zikr,
                newItem: Zikr
            ): Boolean =
                oldItem == newItem
        }
    }
}