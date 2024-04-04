package com.bbs.learnandtest.recyclerview.concatadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bbs.learnandtest.R
import com.bbs.learnandtest.recyclerview.data.MyHeaderFooterData

class MyFooterAdpter(
    private val myFooterData: MyHeaderFooterData,
) : RecyclerView.Adapter<MyHeaderFooterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHeaderFooterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_header_footer_view_holder, parent, false)
        return MyHeaderFooterViewHolder(view)
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: MyHeaderFooterViewHolder, position: Int) {
        holder.textViewDone.text = myFooterData.msg
        holder.progressBarLoading.visibility = if (myFooterData.showLoading) View.VISIBLE else View.GONE
    }
}