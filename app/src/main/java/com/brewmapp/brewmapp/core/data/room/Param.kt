package com.bignerdranch.android.osm.data.room

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "params")
data class Param(var id: String, var name: String, var getThumb: String, var type: String) {
    @PrimaryKey(autoGenerate = true)
    var idKey: Long = 0
}