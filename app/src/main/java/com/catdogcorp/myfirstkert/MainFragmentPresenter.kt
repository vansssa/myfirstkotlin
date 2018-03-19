package com.catdogcorp.myfirstkert

interface MainFragmentPresenter {

    fun getRandomData() : ArrayList<Int>

    fun startTimer()

    fun stopTimer()

    fun getGameResult() : String

    fun onNumItemClicked(num : Int)
}