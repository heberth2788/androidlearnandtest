package com.bbs.learnandtest.recyclerview.concatadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bbs.learnandtest.R
import com.bbs.learnandtest.recyclerview.MyViewHolder
import com.bbs.learnandtest.recyclerview.data.MyCustomData

class MyListAdapter(
    private val myDataSet: List<MyCustomData>,
) : RecyclerView.Adapter<MyItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_list_view_holder, parent, false)
        return MyItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyItemViewHolder, position: Int) {
        holder.textViewDateList.text = myDataSet[position].date
        holder.textViewReportTitleList.text = myDataSet[position].title
        holder.imageViewList.setImageResource(android.R.drawable.ic_menu_camera)
    }

    override fun getItemCount(): Int = myDataSet.size
}