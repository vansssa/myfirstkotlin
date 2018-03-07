package com.catdogcorp.myfirstkert

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Button
import java.util.*

class MyHolder(itemView: View, leftData: ArrayList<Int>, hint_listener: callback) : RecyclerView.ViewHolder(itemView) {

    var button: Button = itemView.findViewById(R.id.bt_number)
    var leftData = leftData
    var hint_listener = hint_listener

    // static var in kotlin
    companion object {
        var nowNumber: Int = 1
    }

    fun initContent(num: Int) {
        button.text = num.toString()
        button.tag = num
        button.setOnClickListener {
            onNumberClicked()
        }

    }

    private fun onNumberClicked() {
        if( button.tag.toString() ==  nowNumber.toString()) {
            updateContent( nowNumber)

        }
    }

    private fun updateContent(num: Int?) {

        if (num != null) {
            //nowNumber = getRamdomNum(nowNumber)
            //hint_listener.onItemClickListener(nowNumber)

            nowNumber ++
            hint_listener.onItemClickListener(nowNumber)

            if (num > 25) {
                button.visibility = View.INVISIBLE

            } else {
                button.text = leftData.get(num - 1).toString()
                button.tag = leftData.get(num - 1).toString()
                button.setBackgroundResource(R.color.colorPrimaryDark)
            }

        }
    }

    fun getRamdomNum(num : Int) : Int {

        var temp: Int = num
        while (temp == num) {
            temp = Random().nextInt(50 - num) + num
        }

        Log.i("VA","temp " + temp);
        return temp
    }

    interface callback {
        fun onItemClickListener(num: Int)
    }
}


