package com.shersar.ramazon2023.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.data.local.entity.Zikr

class ItemsAdapter(
    private val context: Context,
    private var zikrs: List<Zikr>
) :
    RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_drawer_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(zikrs[position])
    }

    override fun getItemCount(): Int {
        return zikrs.size
    }

    class ItemViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {

        fun bind(zikr: Zikr) {
//            view.findViewById<TextView>(R.id.tv_number_order).text = zikr.order_number.toString()
            view.findViewById<TextView>(R.id.tv_name_zikr_uzb).text = zikr.uzb_zikr
            view.findViewById<TextView>(R.id.tv_name_zikr_arab).text = zikr.arab_zikr
            view.findViewById<TextView>(R.id.tv_today_zikr).text = zikr.today_zikr
            view.findViewById<TextView>(R.id.tv_all_zikr).text = zikr.all_zikr
        }
    }
}
