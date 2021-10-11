package com.example.studydiary.DB.Diary

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
}