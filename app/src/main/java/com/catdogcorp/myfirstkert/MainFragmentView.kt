package com.catdogcorp.myfirstkert

/**
 * Created by vanessatsai on 2018/3/7.
 */
interface MainFragmentView {

    fun showTimer(num : Int)

    fun showHint(num : Int)

    fun newGame()

    fun showYourScore(num: Int)
}