package com.example.studydiary.DB.Subject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.studydiary.Model.Subject

@Database(entities = [Subject::class], version = 2)
abstract class SubjectDatabase : RoomDatabase() {
    abstract fun subjectDao() : SubjectDao

    companion object{
        @Volatile
        private var INSTANCE : SubjectDatabase? = null

        fun getInstance(context: Context) : SubjectDatabase {
            return INSTANCE ?: synchronized(this){
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SubjectDatabase::class.java, "subject_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}