package com.example.android.mydiary.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.mydiary.Notes
import com.example.android.mydiary.R
import com.example.android.mydiary.data.NotesViewModel
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class Add_Note : Fragment() {

    private lateinit var mNotesViewModel: NotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add__note, container, false)

        mNotesViewModel = ViewModelProvider(this).get(NotesViewModel::class.java)

        view.findViewById<ExtendedFloatingActionButton>(R.id.save_note_button).setOnClickListener {
            val title = view.findViewById<TextInputEditText>(R.id.title_edit_text).toString()
            val content = view.findViewById<TextInputEditText>(R.id.content_edit_text).toString()
            val date = Calendar.getInstance().time
            val formatter = SimpleDateFormat.getDateInstance() //or use getDateInstance()
            val formatteddate = formatter.format(date).toString()

            if (inputCheck(title, content)) {
                //Create Notes Object
                val notes = Notes(0, title, content, formatteddate)
                // Add Note to Database
                mNotesViewModel.addNote(notes)
                Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
                //Navigate back
               findNavController().navigate(R.id.action_add_Note_to_note_List)

            }else{
                Toast.makeText(requireContext(),"Please fill out all fields",Toast.LENGTH_LONG).show()
            }


        }

    return view
    }

}

private fun inputCheck(title: String, content: String): Boolean {
    return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(content))
}




