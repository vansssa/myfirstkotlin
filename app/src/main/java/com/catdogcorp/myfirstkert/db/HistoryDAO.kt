package com.catdogcorp.myfirstkert.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.catdogcorp.myfirstkert.db.History.Companion.TABLE_SCORES

@Dao
interface HistoryDAO{

    @Query("Select * from "+ TABLE_SCORES )
    fun getScoreList() : List<History>
    //Note: can't be use ArrayList: https://stackoverflow.com/questions/49259670/not-sure-how-to-convert-cursor-to-this-method-return-type

    @Insert(onConflict = REPLACE)
    fun updateScores(history: History)
}