package com.bbs.learnandtest.recyclerview.concatadapter

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bbs.learnandtest.R

class MyHeaderFooterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val textViewDone: TextView
    val progressBarLoading: ProgressBar

    init {
        textViewDone = itemView.findViewById(R.id.textViewDone)
        progressBarLoading = itemView.findViewById(R.id.progressBarLoading)
    }
}