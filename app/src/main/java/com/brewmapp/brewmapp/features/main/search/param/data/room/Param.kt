package com.bignerdranch.android.osm.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "params")
data class Param(var id: String, var name: String, var getThumb: String, var type: String) {
    @PrimaryKey(autoGenerate = true)
    var idKey: Long = 0
}