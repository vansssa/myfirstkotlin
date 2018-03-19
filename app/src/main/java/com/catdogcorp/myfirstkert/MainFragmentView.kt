package com.catdogcorp.myfirstkert

interface MainFragmentView {

    fun showTimer(num : String)

    fun showHint(num : Int)

    fun newGame()

    fun showYourScore(num: String)

    fun resetUI()
}