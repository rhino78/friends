package com.example.friends

import android.os.Bundle
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log.d
import android.widget.*
import kotlinx.android.synthetic.main.adapter_item_layout.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val dataList = ArrayList<Model>()
        dataList.add(Model("Thomas", 1))
        dataList.add(Model("Evan", 2))
        dataList.add(Model("Dane", 3))
        dataList.add(Model("Camo", 4))
        dataList.add(Model("Alex", 5))
        dataList.add(Model("Jorge", 6))
        dataList.add(Model("Rayyan", 7))
        dataList.add(Model("Shreyan", 8))
        dataList.add(Model("Torben", 9))
        dataList.add(Model("Mitchell", 10))
//        pass the values to RvAdapter
        val rvAdapter = RvAdapter(dataList)
//        set the recyclerView to the adapter

        recyclerView.adapter = rvAdapter
    }
}
