package com.shersar.ramazon2023.utils

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.model.Question

class QuestionDialogFragment(private val question:Question):DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogView = layoutInflater.inflate(R.layout.dialog_question, null)
        dialogView.findViewById<TextView>(R.id.tv_title_question).text = question.title
        dialogView.findViewById<TextView>(R.id.tv_answer).text = question.answer

        return AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .create()
    }
}