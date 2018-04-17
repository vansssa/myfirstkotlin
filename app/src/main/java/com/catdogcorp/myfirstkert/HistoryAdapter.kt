package com.catdogcorp.myfirstkert

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.catdogcorp.myfirstkert.db.History

class HistoryAdapter (var context: Context, var dataList: ArrayList<History>) : RecyclerView.Adapter<HistoryHolder>() {

    //var firstDataList : ArrayList<History> = dataList


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HistoryHolder {
        val v : View = LayoutInflater.from(parent!!.context).inflate(R.layout.item_history, parent, false)
        return HistoryHolder(v, dataList)
    }

    override fun onBindViewHolder(holder: HistoryHolder?, position: Int) {
       holder!!.initContent(dataList.get(position))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}