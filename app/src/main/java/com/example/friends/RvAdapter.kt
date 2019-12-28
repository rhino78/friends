package com.example.friends

import android.os.SystemClock
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import kotlin.collections.ArrayList
import android.util.Log.d
import android.widget.Button
import android.widget.Chronometer
import android.widget.Chronometer.OnChronometerTickListener
import java.text.DateFormat


class RvAdapter(val userList: ArrayList<Model>) : RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        val v = LayoutInflater.from(p0.context).inflate(R.layout.adapter_item_layout, p0, false)
        val chrono = v.findViewById<Chronometer>(R.id.chronometer2)
        chrono.base = SystemClock.elapsedRealtime()
        chrono.setText("00:00:00")
        val btnStart = v.findViewById<Switch>(R.id.switch1)
        val btnReset = v.findViewById<Button>(R.id.button)
        var stoptime:Long = 0

        btnStart?.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                d("isChecked", ":$isChecked")
                chrono.base=SystemClock.elapsedRealtime()+stoptime
                chrono.start()
            }
            else{
                d("isChecked", ":$isChecked")
                stoptime=chrono.base-SystemClock.elapsedRealtime()
                chrono.stop()
            }

        }

        btnReset.setOnClickListener{
            stoptime=chrono.base-SystemClock.elapsedRealtime()
            stoptime=0
            chrono.stop()
            chrono.base=SystemClock.elapsedRealtime()+stoptime
        }

        return ViewHolder(v)
    }
    override fun getItemCount(): Int {
        return userList.size
    }
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        p0.name?.text = userList[p1].name
        p0.count?.text = userList[p1].count.toString()

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.playerName)
        val count = itemView.findViewById<TextView>(R.id.playerPlayingTime)

        }
}
