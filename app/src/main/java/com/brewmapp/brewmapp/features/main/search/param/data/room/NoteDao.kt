package com.bignerdranch.android.osm.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import io.reactivex.Single

@Dao
interface NoteDao {
    @Insert
    fun addParams(params: List<Param>)

    @Query("SELECT * FROM params WHERE type = :type")
    fun getParams(type: String): Single<List<Param>>

    @Delete
    fun deleteParams(params: List<Param>)

    @Query("DELETE FROM params")
    fun deleteAll()
}