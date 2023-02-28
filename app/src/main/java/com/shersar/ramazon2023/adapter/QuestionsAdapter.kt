package com.shersar.ramazon2023.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shersar.ramazon2023.databinding.ItemQuestionBinding
import com.shersar.ramazon2023.model.Question
import com.shersar.ramazon2023.utils.QuestionDialogFragment

class QuestionsAdapter(private val itemList: MutableList<Question>) :
    RecyclerView.Adapter<QuestionsAdapter.ContentDataViewHolder>() {


    inner class ContentDataViewHolder(val itemQuestioneRv: ItemQuestionBinding) :
        RecyclerView.ViewHolder(itemQuestioneRv.root) {

        fun onBind(data: Question) {
            itemQuestioneRv.apply {
                tvQuestion.text = data.title
                tvQuestionNumber.text = (adapterPosition+1).toString()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentDataViewHolder {
        return ContentDataViewHolder(
            ItemQuestionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ContentDataViewHolder, position: Int) {
        holder.onBind(itemList[position])
        holder.itemView.setOnClickListener {
            val textDialog = QuestionDialogFragment(itemList[position])
            textDialog.show((holder.itemView.context as AppCompatActivity).supportFragmentManager, "TextDialogFragment")
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun updateList(newItemList: List<Question>) {
        val diffResult = DiffUtil.calculateDiff(MyDiffUtilCallback(itemList, newItemList))
        itemList.clear()
        itemList.addAll(newItemList)
        diffResult.dispatchUpdatesTo(this)
    }


    inner class MyDiffUtilCallback(
        private val oldList: List<Question>,
        private val newList: List<Question>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].answer == newList[newItemPosition].answer
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}
