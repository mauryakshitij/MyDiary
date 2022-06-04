package com.example.android.mydiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.mydiary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val notes= binding.notes
        val addNotes =binding.addButton
    }
}