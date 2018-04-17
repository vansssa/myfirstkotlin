package com.catdogcorp.myfirstkert.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(History::class), version = 1, exportSchema = false)
//exportSchema: https://developer.android.com/reference/android/arch/persistence/room/Database.html#exportSchema()
abstract class HistoryDataBase : RoomDatabase() {

    abstract fun HistoryDAO() : HistoryDAO

    companion object {
        private var INSTANCE: HistoryDataBase? = null

        fun getInstance(context: Context): HistoryDataBase? {
            if (INSTANCE == null) {
                synchronized(HistoryDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            HistoryDataBase::class.java, "scores.db")
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            if(INSTANCE!=null)
                INSTANCE!!.close()

            INSTANCE = null

        }
    }
}