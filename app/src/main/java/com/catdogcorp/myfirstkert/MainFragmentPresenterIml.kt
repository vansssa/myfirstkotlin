package com.catdogcorp.myfirstkert

import android.os.Handler
import android.os.Message
import java.util.*

class MainFragmentPresenterIml(mainFragment : MainFragment) : MainFragmentPresenter {


    val numberOfColumns : Int = 5
    val numberOfTotal : Int = 50
    var mainFragmentView = mainFragment
    var period : Long = 0
    var timer : Timer? = null

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

        timer = Timer(true)
        timer!!.schedule(MyTimerTask(System.currentTimeMillis()), 0, 100)
    }

    override fun stopTimer() {
        if(timer !=null)
            timer!!.cancel()
    }

    override fun getGameResult(): String {
        return (period / 1000).toString() + ":" + period % 1000
    }

    override fun onNumItemClicked(num: Int) {
        handler
    }

    private inner class MyTimerTask(time: Long) : java.util.TimerTask() {
        var initTime = time
        override fun run() {
            period = System.currentTimeMillis() - initTime
            val message = Message()
            message.what = 1
            handler.sendMessage(message)
        }
    }


    private var handler = object :  Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when (msg.what) {
                1 -> mainFragmentView.showTimer(getGameResult())
            }
        }
    }

}