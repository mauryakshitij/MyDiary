package com.example.android.mydiary.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.core.content.ContentProviderCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.android.mydiary.Notes
import com.example.android.mydiary.R
import com.example.android.mydiary.data.NotesViewModel
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.nio.file.Files.delete
import java.text.SimpleDateFormat
import java.util.*


class Note_Update : Fragment() {

    private val args by navArgs<Note_UpdateArgs>()
    private lateinit var mNotesViewModel: NotesViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_note__update,container, false)
        view.findViewById<TextInputEditText>(R.id.update_title_edit_text).setText(args.currentNote.noteTitle)
        view.findViewById<TextInputEditText>(R.id.update_content_edit_text).setText(args.currentNote.noteContent)

        mNotesViewModel = ViewModelProvider(this).get(NotesViewModel::class.java)

        view.findViewById<ExtendedFloatingActionButton>(R.id.update_note_button).setOnClickListener {


            val title = view.findViewById<TextInputEditText>(R.id.update_title_edit_text).text.toString()
            val content = view.findViewById<TextInputEditText>(R.id.update_content_edit_text).text.toString()
            val date = Calendar.getInstance().time
            val formatter = SimpleDateFormat.getDateInstance() //or use getDateInstance()
            val formatteddate = formatter.format(date).toString()

            if( inputCheck(title, content)){

                //Create Note Object
                val updatedNote = Notes(args.currentNote.id,title,content,formatteddate)
                //Update current note
                mNotesViewModel.updateNote(updatedNote)
                Toast.makeText(requireContext(),"Updated Successfully!",Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_note_Update_to_note_List)

            }else{
                Toast.makeText(requireContext(),"Please fill out all fields",Toast.LENGTH_SHORT).show()
            }

            //Add menu
            //setHasOptionsMenu(true)

        }




        return view
    }


    private fun inputCheck(title: String, content: String): Boolean {
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(content))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater){
        inflater.inflate(R.menu.delete_menu,menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menu_delete){
            deleteNote()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun deleteNote() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){ _, _ ->
            mNotesViewModel.deleteNote(args.currentNote)
            Toast.makeText(requireContext(),"Successfully removed",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_note_Update_to_note_List)
        }
        builder.setNegativeButton("No"){ _, _ ->}
        builder.setTitle("Delete Note")
        builder.setMessage("Are you sure you wan to delete this note?")
        builder.create().show()

    }

}




