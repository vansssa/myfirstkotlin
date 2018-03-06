package com.catdogcorp.myfirstkert

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Button

class MyHolder(itemView : View, leftData : ArrayList<Int>) : RecyclerView.ViewHolder(itemView) {

    var button: Button = itemView.findViewById(R.id.bt_number)
    private var nowNumber : Int = 0
    var leftData = leftData

    fun initContent(num: Int) {
        button.text = num.toString()
        button.tag = num
        button.setOnClickListener {
            onNumberClicked()
        }
        nowNumber = 1
    }

    private fun onNumberClicked() {
        Log.i("VA"," onNumberClicked number" + nowNumber);
        if( button.tag.toString() == nowNumber.toString()) {
            updateContent(nowNumber)
            nowNumber ++
            Log.i("VA","number" + nowNumber);
        }

    }

    private fun updateContent(num: Int?) {
        if (num != null) {
            if (num > 25) {
                button.visibility = View.INVISIBLE
            } else {
                button.text = leftData.get(num - 1).toString()
                button.tag = leftData.get(num - 1).toString()
                button.setBackgroundResource(R.color.colorPrimaryDark)
            }
        }
    }

}


