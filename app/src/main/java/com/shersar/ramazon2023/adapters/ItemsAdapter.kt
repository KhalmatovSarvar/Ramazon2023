package com.shersar.ramazon2023.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.model.Item

class ItemsAdapter(
    private val context: Context,
    private var items: List<Item>
) :
    RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_drawer_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ItemViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {

        fun bind(item: Item) {
            view.findViewById<TextView>(R.id.tv_number_order).text = item.order_number.toString()
            view.findViewById<TextView>(R.id.tv_name_zikr_uzb).text = item.uzb_zikr
            view.findViewById<TextView>(R.id.tv_name_zikr_arab).text = item.arab_zikr
            view.findViewById<TextView>(R.id.tv_today_zikr).text = item.today_zikr
            view.findViewById<TextView>(R.id.tv_all_zikr).text = item.all_zikr
        }
    }
}
