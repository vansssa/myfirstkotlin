package com.catdogcorp.myfirstkert

/**
 * Created by vanessatsai on 2018/3/6.
 */
interface MainFragmentPresenter {

    fun getRandomData() : ArrayList<Int>

    fun startTimer()

    fun stopTimer()

    fun getGameResult() : String

    fun onNumItemClicked(num : Int)
}