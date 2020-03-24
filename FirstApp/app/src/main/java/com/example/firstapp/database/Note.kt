package com.example.firstapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Note(
    val title: String,
    val date: String,
    val text: String
) {
    @PrimaryKey (autoGenerate = true)
    var id: Int? = null

    override fun toString(): String {
        return "$title, $date, $text"
    }
}