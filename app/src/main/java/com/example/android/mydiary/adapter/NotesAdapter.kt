package com.example.android.mydiary.adapter

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.mydiary.Notes
import com.example.android.mydiary.R

class NotesAdapter(val context: Context) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    //private val allNotes= List<Notes>()

    class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val noteTitle: TextView = view.findViewById(R.id.note_title)
        val noteContent: TextView = view.findViewById(R.id.note_content)
        val noteDate: TextView = view.findViewById(R.id.note_date)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesAdapter.NoteViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.notes, parent, false)

        return NoteViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: NotesAdapter.NoteViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}



