package com.example.studydiary.Model.DB.Diary

import androidx.room.*
import com.example.studydiary.Model.Diary

@Dao
interface DiaryDao {
    @Query("SELECT * FROM diary")
    fun getAll() : Array<Diary>

    @Insert
    fun insert(vararg diary: Diary)

    @Update
    fun update(diary: Diary)

    @Delete
    fun delete(diary: Diary)

    @Query("SELECT * FROM diary WHERE year = :year and month = :month and day = :day")
    fun getDay(year : Int, month : Int, day : Int) : Array<Diary>
}