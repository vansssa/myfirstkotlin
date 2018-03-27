package com.catdogcorp.myfirstkert.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.catdogcorp.myfirstkert.db.History.Companion.TABLE_SCORES


@Entity(tableName = TABLE_SCORES)
data class History (@PrimaryKey(autoGenerate = true) var id: Int,
                    @ColumnInfo(name= "date") var date: String?,
                    @ColumnInfo(name= "score") var score: String? ) {

    companion object {
        const val TABLE_SCORES = "myscores"
    }

    constructor() :this (0," "," ")

}