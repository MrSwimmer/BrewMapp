package com.bignerdranch.android.osm.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Param::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}