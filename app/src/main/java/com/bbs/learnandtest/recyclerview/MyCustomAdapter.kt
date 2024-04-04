package com.bbs.learnandtest.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bbs.learnandtest.R
import com.bbs.learnandtest.recyclerview.data.MyCustomData

class MyCustomAdapter(
    private val myDataSet: List<MyCustomData>,
) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_report_view_holder, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount() : Int = myDataSet.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textViewDate.text = myDataSet[position].date
        holder.textViewReportTitle.text = myDataSet[position].title
        holder.imageView.setImageResource(android.R.drawable.ic_menu_view)
    }
}