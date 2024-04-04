package com.bbs.learnandtest.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bbs.learnandtest.R
import com.bbs.learnandtest.recyclerview.data.MyCustomData

/**
 * RecyclerView
 *
 * - Use RecyclerView instead of ListView and GridView.
 * - Classes:
 *      RecyclerView.ViewHolder :
 *      RecyclerView.Adapter :
 *      RecyclerView.Manager :
 * - Steps :
 *      1. Define an Activity and the layout that will content the RecyclerView in xml and code.
 *      3. Define the RecycleView in xml - RecycleView
 *      2. Define a layout to repeat on the RecyclerView in xml.
 *      3. Define an adapter to fill the recycled layout with some data - Adapter + ViewHolder
 *      4. Define the distribution(List, Grid, StaggeredGrid) - Manager
 *
 * */
class MyRecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //[START recycler_view]
        val myDataSet = listOf(
            MyCustomData(date = "27 SET 1988", image = "", title = "GFGFHFGHF"),
            MyCustomData(date = "28 OCT 1989", image = "", title = "QWEQWEQWE"),
            MyCustomData(date = "29 NOV 1990", image = "", title = "DFSDFDSFD"),
            MyCustomData(date = "30 DIC 1991", image = "", title = "TYRTYYRTY"),
            MyCustomData(date = "31 ENE 1992", image = "", title = "FGNVBNVBN"),
            MyCustomData(date = "01 FEB 1993", image = "", title = "DFTFTDFT"),
        )
        val adapter = MyCustomAdapter(myDataSet)
        val recyclerView: RecyclerView = findViewById(R.id.my_recycler_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        //[END recycler_view]
    }
}