package com.example.android.mydiary.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android.mydiary.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Note_List : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      val view = inflater.inflate(R.layout.fragment_note__list, container, false)


        view.findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener {
            findNavController().navigate(R.id.action_note_List_to_add_Note)
        }

        return view

    }

}