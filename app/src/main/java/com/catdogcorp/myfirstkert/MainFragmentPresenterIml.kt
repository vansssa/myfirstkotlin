package com.catdogcorp.myfirstkert

import java.util.*

/**
 * Created by vanessatsai on 2018/3/6.
 */


class MainFragmentPresenterIml : MainFragmentPresenter {

    val numberOfColumns : Int = 5
    val numberOfTotal : Int = 50


    override fun getRandomData(): ArrayList<Int> {
        var matrix : Int = numberOfColumns * numberOfColumns
        var data : ArrayList<Int> = ArrayList()
        //for --> forEach
        (1 .. numberOfTotal).forEach { i -> data.add(i) }

        Collections.shuffle(data.subList(0, matrix))
        Collections.shuffle(data.subList(matrix, data.size - 1))
        return data
    }

    override fun startTimer() {

    }

    override fun stopTimer() {

    }

    override fun getGameResult(): String {
        return ""
    }

    override fun onNumItemClicked(num: Int) {

    }
}