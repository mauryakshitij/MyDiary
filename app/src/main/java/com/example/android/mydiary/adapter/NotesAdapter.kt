package com.example.android.mydiary.adapter

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.android.mydiary.Notes
import com.example.android.mydiary.R
import com.example.android.mydiary.fragments.Note_List
import com.example.android.mydiary.fragments.Note_ListDirections

class NotesAdapter: RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

   var allNotes= emptyList<Notes>()

    class NoteViewHolder(val view: View) : RecyclerView.ViewHolder(view) {


        val noteTitle: TextView = view.findViewById(R.id.note_title)
        val noteContent: TextView = view.findViewById(R.id.note_content)
        val noteDate: TextView = view.findViewById(R.id.note_date)
        val noteLayout: ConstraintLayout= view.findViewById(R.id.noteConstraintLayout)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.notes, parent, false)

        return NoteViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
       val currentNote = allNotes[position]
        holder.noteTitle.text=currentNote.noteTitle
        holder.noteContent.text=currentNote.noteContent
        holder.noteDate.text=currentNote.noteDate

        holder.noteLayout.setOnClickListener{
            val action = Note_ListDirections.actionNoteListToNoteUpdate(currentNote)
            holder.view.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun setData(note : List<Notes>){
        this.allNotes = note
        notifyDataSetChanged()
    }
}



