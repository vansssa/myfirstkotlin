package com.catdogcorp.myfirstkert

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.catdogcorp.myfirstkert.db.History

class HistoryAdapter (var context: Context, var dataList: ArrayList<History>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val TYPE_HEADER = 1
    val TYPE_NORMAL = 2

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {

        var inflater = parent!!.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var holder : RecyclerView.ViewHolder? = null
        if(viewType == TYPE_NORMAL)
            holder = HistoryHolder(inflater.inflate(R.layout.item_history, parent, false), dataList)
        if(viewType == TYPE_HEADER)
            holder = HistoryHolder(inflater.inflate(R.layout.item_history_header,parent,false))
        return holder!!
    }

    override fun getItemViewType(position: Int): Int {
        if(position == 0)
            return TYPE_HEADER
        return TYPE_NORMAL
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(getItemViewType(position) == TYPE_HEADER)
            return

        (holder as HistoryHolder).initContent(dataList.get(position-1))
    }

    override fun getItemCount(): Int {
        return dataList.size +1
    }


}