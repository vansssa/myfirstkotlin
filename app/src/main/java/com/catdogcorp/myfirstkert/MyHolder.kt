package com.catdogcorp.myfirstkert

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import java.util.*

class MyHolder(itemView: View, nowData: ArrayList<Int>, leftData: ArrayList<Int>, hint_listener: callback) : RecyclerView.ViewHolder(itemView) {

    var button: Button = itemView.findViewById(R.id.bt_number)
    var leftData = leftData
    var nowData = nowData
    var hint_listener = hint_listener

    // static var in kotlin
    companion object {
        var nowNumber: Int = 1
        var steps : Int = 1
    }

    fun initContent(num: Int) {
        button.text = num.toString()
        button.tag = num
        button.setOnClickListener {
            onNumberClicked()
        }
        nowNumber = 1
        steps = 1
    }

    private fun onNumberClicked() {
        if( button.tag.toString() ==  nowNumber.toString()) {
            updateContent( nowNumber)
            steps ++
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun updateContent(num: Int?) {

        if (num != null) {
            nowNumber = getRandomNam(num)
            hint_listener.onItemClickListener(nowNumber)

            if (num > 25) {
                button.setBackgroundResource(R.color.material_blue_grey_800)
                button.setTextColor(R.color.primary_text_disabled_material_dark)
                button.isClickable = false

            } else {
                button.text = leftData.get(num - 1).toString()
                button.tag = leftData.get(num - 1).toString()
                button.setBackgroundResource(R.color.material_deep_teal_500)
            }

        }
    }

    fun getRandomNam(num : Int) : Int {
        var result : Int? = num
        if(steps < 25) {
            nowData.remove(num)
            result = nowData[Random().nextInt(nowData.size)]

        }
        else if(steps < 50) {
            leftData.remove(num)
            result = leftData[Random().nextInt(leftData.size)]
        }
        return result!!
    }

    interface callback {
        fun onItemClickListener(num: Int)
    }
}


