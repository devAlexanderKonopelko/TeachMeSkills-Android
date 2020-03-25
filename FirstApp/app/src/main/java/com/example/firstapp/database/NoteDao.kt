package com.example.firstapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Insert
    suspend fun addNote(note: Note)

    @Query("DELETE FROM Note WHERE title = :title")
    suspend fun deleteNote(title: String)

    @Query ("SELECT * FROM Note WHERE title = :title")
    suspend fun getAllNotesByTitle(title: String): List<Note>
}