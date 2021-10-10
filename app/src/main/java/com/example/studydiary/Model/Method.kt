package com.example.studydiary.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "study_method")
data class Method(
    @PrimaryKey(autoGenerate = true)
    val _id : Int = 0,

    @ColumnInfo(name = "name")
    val name : String,

    @ColumnInfo(name = "explanation")
    val explanation : String,

    @ColumnInfo(name = "subject")
    val subject : String,
) : Serializable