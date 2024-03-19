package com.bbs.learnandtest.recyclerview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bbs.learnandtest.R

class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val imageView: ImageView
    val textViewDate: TextView
    val textViewReportTitle: TextView

    init {
        imageView = view.findViewById(R.id.imageView)
        textViewDate = view.findViewById(R.id.textViewDate)
        textViewReportTitle = view.findViewById(R.id.textViewReportTitle)
    }
}