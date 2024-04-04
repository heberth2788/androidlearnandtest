package com.bbs.learnandtest.recyclerview.concatadapter

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bbs.learnandtest.R
import com.bbs.learnandtest.recyclerview.data.MyCustomData
import com.bbs.learnandtest.recyclerview.data.MyHeaderFooterData

class MyRecyclerViewWithConcatAdapterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_recycler_view_with_concat_adapter)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // [START recycler_view_with_concat_adapter]
        // Creating the datasets
        val headerData = MyHeaderFooterData(msg = "Done!", showLoading = false)
        val footerData = MyHeaderFooterData(msg = "", showLoading = true)
        val myDataSet = listOf(
            MyCustomData(date = "27 SET 1988", image = "", title = "GFGFHFGHF"),
            MyCustomData(date = "28 OCT 1989", image = "", title = "QWEQWEQWE"),
            MyCustomData(date = "29 NOV 1990", image = "", title = "DFSDFDSFD"),
            MyCustomData(date = "30 DIC 1991", image = "", title = "TYRTYYRTY"),
            MyCustomData(date = "31 ENE 1992", image = "", title = "FGNVBNVBN"),
            MyCustomData(date = "01 FEB 1993", image = "", title = "DFTFTDFT"),
        )

        // Creating the adapters
        val headerAdapter = MyHeaderAdapter(headerData)
        val footerAdapter  =  MyFooterAdpter(footerData)
        val listAdapter = MyListAdapter(myDataSet)

        // Creating the concat adapter
        val configBuilder = ConcatAdapter
            .Config.Builder()
            .setIsolateViewTypes(true)
        val concatAdapter = ConcatAdapter(
            configBuilder.build(),
            headerAdapter,
            listAdapter,
            footerAdapter,
        )

        // Creating the recycler view
        val recyclerView: RecyclerView = findViewById(R.id.my_recycler_view_with_concat_adapter)
        recyclerView.adapter = concatAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // [END recycler_view_with_concat_adapter]
    }
}