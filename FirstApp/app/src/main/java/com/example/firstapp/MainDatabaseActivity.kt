package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.firstapp.database.Note
import com.example.firstapp.database.NoteDatabase
import kotlinx.android.synthetic.main.activity_main_database.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainDatabaseActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_database)

        writeButton.setOnClickListener(this)
        findButton.setOnClickListener(this)
        deleteButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val database = NoteSingleton.getInstance(this).database
        when (v?.id) {
            writeButton.id -> {
                if (noteTitle.text.toString() != "" &&
                    noteDate.text.toString() != "" &&
                    noteText.text.toString() != ""
                ) {
                    CoroutineScope(Dispatchers.IO).launch {
                        database.getNoteDao().addNote(
                            Note(
                                noteTitle.text.toString(),
                                noteDate.text.toString(),
                                noteText.text.toString()
                            )
                        )
                        withContext(Dispatchers.Main) {
                            noteTitle.text.clear()
                            noteDate.text.clear()
                            noteText.text.clear()
                        }
                    }
                    Toast.makeText(this, "Write successful!", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(this, "Error. Fill all the fields", Toast.LENGTH_LONG).show()
                }
            }

            findButton.id -> {
                if (noteTitle.text.toString() != "") {
                    CoroutineScope(Dispatchers.IO).launch {
                        val notesList = database.getNoteDao().getAllNotesByTitle(noteTitle.text.toString())

                        withContext(Dispatchers.Main) {
                            if (notesList.size == 1) outputField.text = notesList[0].toString()
                            else {
                                var textToShow = ""
                                notesList.forEach() {
                                    textToShow += it.toString() + "\n"
                                }
                                outputField.text = textToShow
                            }
                            noteTitle.text.clear()
                        }
                    }
                }
                else {
                    Toast.makeText(this, "Error. Fill Title field", Toast.LENGTH_LONG).show()
                }
            }

            deleteButton.id -> {
                if (noteTitle.text.toString() != "") {
                    CoroutineScope(Dispatchers.IO).launch {
                        database.getNoteDao().deleteNote(noteTitle.text.toString())
                        withContext(Dispatchers.Main) {
                            noteTitle.text.clear()
                        }
                    }
                }
                else {
                    Toast.makeText(this, "Error. Fill Title field", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
