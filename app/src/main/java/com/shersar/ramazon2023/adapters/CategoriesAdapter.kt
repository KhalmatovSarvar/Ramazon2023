package com.shersar.ramazon2023.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.model.Item
import com.shersar.ramazon2023.model.Zikrlar

class CategoriesAdapter(
    private val context: Context,
    private val list: List<Item>,
    val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_drawer_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        // holder.bind(list[position])
        val Items = list[position]
        holder.uzb.text = Items.uzb_zikr
        holder.arab.text = Items.arab_zikr
        holder.tarjima.text = Items.tarjima
        holder.todayZikr.text = Items.today_zikr
        holder.allZikr.text = Items.all_zikr
        holder.orderNumber.text = Items.order_number.toString()

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val uzb: TextView = view.findViewById(R.id.tv_name_zikr_uzb)
        val arab: TextView = view.findViewById(R.id.tv_name_zikr_arab)
        val tarjima: TextView = view.findViewById(R.id.tv_tarjima)
        val allZikr: TextView = view.findViewById(R.id.tv_all_zikr)
        val todayZikr: TextView = view.findViewById(R.id.tv_today_zikr)
        val orderNumber: TextView = view.findViewById(R.id.tv_number_order)
        fun bind(item: Item) {
            val uzb = item.uzb_zikr
            // uzb.text=item.uzb_zikr
//            item.setOnClickListener {
//                onItemClick(item.uzb_zikr)
//            }
        }

    }
}