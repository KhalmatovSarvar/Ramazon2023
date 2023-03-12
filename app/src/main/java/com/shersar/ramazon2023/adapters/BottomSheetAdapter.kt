package com.shersar.ramazon2023.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.model.Bottomsheet
import kotlinx.android.synthetic.main.item_bottomsheet.view.*


class BottomSheetAdapter( val list: ArrayList<Bottomsheet>) :
    RecyclerView.Adapter<BottomSheetAdapter.ViewHolder>() {
    private var isNewRadioButtonChecked = false
    private var lastCheckedPosition = -1
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BottomSheetAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_bottomsheet, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modelClass = list[position]
        holder.itemView.tv_city.text = modelClass.city_name

        if (isNewRadioButtonChecked) {
            holder.itemView.radio_btn.isChecked = modelClass.isSelected
        } else {
            if (holder.adapterPosition == 0) {
                holder.itemView.radio_btn.isChecked = true
                lastCheckedPosition = 0
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            itemView.radio_btn.setOnClickListener {
                handleRadiobuttonChecks(adapterPosition)
            }
        }
    }

    private fun handleRadiobuttonChecks(adapterPosition: Int) {
        isNewRadioButtonChecked = true
        list[lastCheckedPosition].isSelected = false
        list[adapterPosition].isSelected = true
        lastCheckedPosition = adapterPosition
        notifyDataSetChanged()
    }
}