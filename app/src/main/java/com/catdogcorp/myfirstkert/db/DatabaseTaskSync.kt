package com.catdogcorp.myfirstkert.db

import android.content.Context
import android.os.AsyncTask
import java.util.*

class DatabaseTaskSync(context: Context, listener: Callback) : AsyncTask<Void, Void, ArrayList<History>>() {

    interface Callback {
        fun onTaskDone(result: ArrayList<History>)
    }

    var context = context
    var callback:Callback = listener


    override fun doInBackground(vararg params: Void?): ArrayList<History> {
        var database: HistoryDataBase? = HistoryDataBase.getInstance(context)
        return ArrayList(database?.HistoryDAO()?.getScoreList())
    }

    override fun onPostExecute(result: ArrayList<History>) {
        callback.onTaskDone(result)
    }

}