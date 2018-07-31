package com.bignerdranch.android.osm.data.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Update
import io.reactivex.Single

@Dao
interface NoteDao {
    @Insert
    fun addParams(params: List<Param>)

    @Query("SELECT * FROM params WHERE id = :id AND type = :type")
    fun getById(id: String, type: String): Single<List<Param>>

    @Query("SELECT * FROM params WHERE id = :id AND type = :type")
    fun getAll(id: String, type: String): Single<List<Param>>

    @Delete
    fun delete(param: Param)

    @Query("DELETE FROM params")
    fun deleteAll()
}