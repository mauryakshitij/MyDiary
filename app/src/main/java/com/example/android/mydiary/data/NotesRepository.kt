package com.example.android.mydiary.data

import androidx.lifecycle.LiveData
import com.example.android.mydiary.Notes

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

    suspend fun deleteAllNotes(){
        notesDao.deleteAllNotes()
    }



}