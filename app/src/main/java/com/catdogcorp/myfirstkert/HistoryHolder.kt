package com.catdogcorp.myfirstkert

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.catdogcorp.myfirstkert.db.History

class HistoryHolder(itemView: View, historyList: ArrayList<History>? = null) : RecyclerView.ViewHolder(itemView) {



    var no : TextView = itemView.findViewById(R.id.tx_no)
    var spend_time : TextView = itemView.findViewById(R.id.tx_spend_time)
    var play_datetime : TextView = itemView.findViewById(R.id.tx_play_datetime)

    fun initContent(history : History) {
        if(history == null )
            return
       no.text = history.id.toString()
       spend_time.text = history.score.toString()
       play_datetime.text = history.date.toString()
    }

}


