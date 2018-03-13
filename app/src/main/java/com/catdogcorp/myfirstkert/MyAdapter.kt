package com.catdogcorp.myfirstkert

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by vanessatsai on 2018/3/5.
 */
class MyAdapter (var context: Context, var dataList: ArrayList<Int>,  var number: Int) : RecyclerView.Adapter<MyHolder>() {

    var firstDataList : ArrayList<Int> = ArrayList(dataList.subList(0 ,number*number))
    var secondDataList : ArrayList<Int> = ArrayList(dataList.subList(number*number,dataList.size))

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder {
        val v : View = LayoutInflater.from(parent!!.context).inflate(R.layout.num_item, parent, false)
        return MyHolder(v, firstDataList , secondDataList, callback)
    }

    override fun onBindViewHolder(holder: MyHolder?, position: Int) {
       holder!!.initContent(firstDataList.get(position))
    }

    override fun getItemCount(): Int {
        return firstDataList.size
    }

    private lateinit var callback: MyHolder.callback

    fun setCallback(callback : MyHolder.callback) {
        this.callback = callback
    }


}