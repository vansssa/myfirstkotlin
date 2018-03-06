package com.catdogcorp.myfirstkert

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button

/**
 * Created by vanessatsai on 2018/3/5.
 */
class MyHolder(itemView : View, subData : ArrayList<Int>) : RecyclerView.ViewHolder(itemView) {

    var button: Button = itemView.findViewById(R.id.bt_number)

    fun initContent(num: Int) {
        button.text = num.toString()
        button.tag = num
    }
}