package com.example.studydiary.Activity.Splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.studydiary.Activity.MainActivity.MainActivity
import com.example.studydiary.DB.Diary.DiaryDatabase
import com.example.studydiary.DB.Method.MethodDatabase
import com.example.studydiary.DB.Subject.SubjectDatabase
import com.example.studydiary.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

lateinit var methodDB : MethodDatabase
lateinit var subjectDB : SubjectDatabase
lateinit var diaryDB : DiaryDatabase

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        methodDB = MethodDatabase.getInstance(this)
        subjectDB = SubjectDatabase.getInstance(this)
        diaryDB = DiaryDatabase.getInstance(this)


        val intent = Intent(this, MainActivity::class.java)
        CoroutineScope(Dispatchers.IO).launch {
//            methodDB.methodDao().clearAll()
            delay(1000)
            startActivity(intent)
            finish()
        }
    }
}