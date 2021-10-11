package com.example.studydiary.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import javax.security.auth.Subject

@Entity(tableName = "diary")
data class Diary(
    @PrimaryKey(autoGenerate = true)
    val _id : Int = 0,

    @ColumnInfo(name = "focus")
    val focus : Int,
    @ColumnInfo(name = "ability")
    val ability : Int,
    @ColumnInfo(name = "subject")
    val subject: String,
    @ColumnInfo(name = "method")
    val method : String,
    @ColumnInfo(name = "content")
    val content : String,

//    @ColumnInfo(name = "date")
//    val date : LocalDate = LocalDate.now(),

    @ColumnInfo(name = "year")
    val year : Int = LocalDate.now().year,
    @ColumnInfo(name = "month")
    val month : Int = LocalDate.now().monthValue,
    @ColumnInfo(name = "day")
    val day : Int = LocalDate.now().dayOfMonth,
)
