package com.example.android.mydiary

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "notesTable")
class Notes(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name= "title") val noteTitle: String,
    @ColumnInfo(name= "content") val noteContent: String,
    @ColumnInfo(name= "date") val noteDate: String
)




