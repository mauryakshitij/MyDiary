package com.example.android.mydiary

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName= "notesTable")
class Notes(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name= "title") val noteTitle: String,
    @ColumnInfo(name= "content") val noteContent: String,
    @ColumnInfo(name= "date") val noteDate: String
): Parcelable




