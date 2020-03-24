package com.example.firstapp.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database (entities = arrayOf(Note::class), version = 1)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun getNoteDao(): NoteDao
}