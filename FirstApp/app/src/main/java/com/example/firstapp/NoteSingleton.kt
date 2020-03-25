package com.example.firstapp

import android.content.Context
import androidx.room.Room
import com.example.firstapp.database.Note
import com.example.firstapp.database.NoteDatabase

class NoteSingleton(context: Context) {
    val database by lazy {
        Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            "notes-database").build()
    }

    companion object {
        fun getInstance(context: Context) = NoteSingleton(context)
    }
}