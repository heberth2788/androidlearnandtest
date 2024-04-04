package com.bbs.learnandtest.recyclerview.concatadapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bbs.learnandtest.R

class MyItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val imageViewList: ImageView
    val textViewReportTitleList: TextView
    val textViewDateList: TextView

    init {
        imageViewList = itemView.findViewById(R.id.imageViewList)
        textViewReportTitleList = itemView.findViewById(R.id.textViewReportTitleList)
        textViewDateList = itemView.findViewById(R.id.textViewDateList)
    }
}