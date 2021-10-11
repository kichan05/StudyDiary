package com.example.studydiary.DB.Diary

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.studydiary.Model.Diary

@Database(entities = [Diary::class], version = 1)
abstract class DiaryDatabase : RoomDatabase() {
    abstract fun diaryDao() : DiaryDao

    companion object{
        @Volatile
        private var INSTANCE : DiaryDatabase? = null

        fun getInstance(context: Context) : DiaryDatabase{
            return INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                DiaryDatabase::class.java, "diary_database"
            )
                .fallbackToDestructiveMigration()
                .build()
                .also { INSTANCE = it }
        }
    }
}