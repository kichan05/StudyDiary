package com.example.studydiary.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "subject")
data class Subject(
    @PrimaryKey(autoGenerate = true)
    val _id : Int = 0,

    @ColumnInfo(name = "subject_name")
    val subject_name : String
) : Serializable
