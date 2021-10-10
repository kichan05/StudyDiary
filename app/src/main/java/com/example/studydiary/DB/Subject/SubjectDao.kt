package com.example.studydiary.DB.Subject

import androidx.room.*
import com.example.studydiary.Model.Subject

@Dao
interface SubjectDao {
    @Query("SELECT * FROM subject")
    fun getAll() : Array<Subject>

    @Insert
    fun insert(vararg subject: Subject)

    @Update
    fun update(subject: Subject)

    @Delete
    fun delete(subject: Subject)
}