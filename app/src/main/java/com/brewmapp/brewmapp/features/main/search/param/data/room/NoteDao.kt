package com.bignerdranch.android.osm.data.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Delete
import io.reactivex.Single

@Dao
interface NoteDao {
    @Insert
    fun addParams(params: List<Param>)

    @Query("SELECT * FROM params WHERE type = :type")
    fun getAllByType(type: String): Single<List<Param>>

    @Delete
    fun delete(param: Param)

    @Query("DELETE FROM params")
    fun deleteAll()
}