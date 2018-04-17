package com.catdogcorp.myfirstkert

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MainAdapter (var context: Context, var dataList: ArrayList<Int>, var number: Int) : RecyclerView.Adapter<MainHolder>() {

    var firstDataList : ArrayList<Int> = ArrayList(dataList.subList(0 ,number*number))
    var secondDataList : ArrayList<Int> = ArrayList(dataList.subList(number*number,dataList.size))

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainHolder {
        val v : View = LayoutInflater.from(parent!!.context).inflate(R.layout.item_num, parent, false)
        return MainHolder(v, firstDataList , secondDataList, callback)
    }

    override fun onBindViewHolder(holder: MainHolder?, position: Int) {
       holder!!.initContent(firstDataList.get(position))
    }

    override fun getItemCount(): Int {
        return firstDataList.size
    }

    private lateinit var callback: MainHolder.callback

    fun setCallback(callback : MainHolder.callback) {
        this.callback = callback
    }


}