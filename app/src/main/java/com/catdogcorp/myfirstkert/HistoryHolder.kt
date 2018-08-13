package com.catdogcorp.myfirstkert

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.catdogcorp.myfirstkert.db.History

class HistoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    //private var historyList: ArrayList<History>? = null

    //If the class has a primary constructor, each secondary constructor needs to delegate to the primary constructor,
    // either directly or indirectly through another secondary constructor(s).
    // Delegation to another constructor of the same class is done using the this keyword:
    //constructor(itemView: View, historyList: ArrayList<History>):this(itemView){
    //    this.historyList  = historyList
    //}

    var no : TextView = itemView.findViewById(R.id.tx_no)
    var spend_time : TextView = itemView.findViewById(R.id.tx_spend_time)
    var play_datetime : TextView = itemView.findViewById(R.id.tx_play_datetime)

    fun initContent(record :History) {
       no.text = record.id.toString()
       spend_time.text = record.score.toString()
       play_datetime.text = record.date.toString()
    }


}


