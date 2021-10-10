package com.example.studydiary.DB.Method

import androidx.room.*
import com.example.studydiary.Model.Method

@Dao
interface MethodDao {
    @Query("SELECT * FROM study_method")
    fun getAll() : Array<Method>

    @Query("SELECT * FROM study_method WHERE subject == :subject")
    fun getSubject(subject : String) : Array<Method>

    @Insert
    fun insert(vararg method : Method)

    @Update
    fun update(method: Method)

    @Delete
    fun delete(method: Method)

    @Query("DELETE FROM study_method")
    fun clearAll()
}