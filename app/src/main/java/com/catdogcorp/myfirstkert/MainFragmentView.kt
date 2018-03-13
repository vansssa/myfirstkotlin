package com.catdogcorp.myfirstkert

/**
 * Created by vanessatsai on 2018/3/7.
 */
interface MainFragmentView {

    fun showTimer(num : String)

    fun showHint(num : Int)

    fun newGame()

    fun showYourScore(num: String)

    fun resetUI()
}