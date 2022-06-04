package com.example.android.mydiary

import androidx.lifecycle.LiveData

class NotesRepository(private val notesDao: NotesDao){
    val allNotes: LiveData<List<Notes>> = notesDao.getAllNotes()

    suspend fun insert(notes: Notes){
        notesDao.insert(notes)
    }
    suspend fun delete(notes: Notes){
        notesDao.delete(notes)
    }
    suspend fun update(notes: Notes){
        notesDao.update(notes)
    }



}