package com.example.studydiary.Model.DB.Method

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.studydiary.Model.Method

@Database(entities = [Method::class], version = 2)
abstract class MethodDatabase : RoomDatabase() {
    abstract fun methodDao() : MethodDao

    companion object{
        @Volatile
        private var INSTANCE : MethodDatabase? = null

        fun getInstance(context: Context) : MethodDatabase{
            return INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                MethodDatabase::class.java,
                "mathod_database"
            )
                .fallbackToDestructiveMigration()
                .build()
                .also { INSTANCE = it }
        }
    }
}