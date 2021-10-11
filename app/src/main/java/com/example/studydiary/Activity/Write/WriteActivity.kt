package com.example.studydiary.Activity.Write

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.studydiary.Activity.Splash.diaryDB
import com.example.studydiary.Model.Diary
import com.example.studydiary.R
import com.example.studydiary.databinding.ActivityWriteBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WriteActivity : AppCompatActivity() {
    lateinit var binding : ActivityWriteBinding
    var inputDiaryContent = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_write)

        val diary = intent.getSerializableExtra("diary") as Diary

        with(binding){
            btnWriteActivityBack.setOnClickListener{finish()}

            btnWriteActivitySubmit.setOnClickListener{
                inputDiaryContent = edtWriteActivityContent.text.toString()
                if(!inputEmptyCheck()){return@setOnClickListener}

                diary.content = inputDiaryContent
                CoroutineScope(Dispatchers.IO).launch {
                    diaryDB.diaryDao().insert(diary)
                    withContext(Dispatchers.Main){
                        Log.d("write", diary.toString())
                        finish()
                    }
                }
            }
        }
    }

    fun inputEmptyCheck(): Boolean {
        if(inputDiaryContent.isEmpty()){
            binding.edtWriteActivityContent.error = "일기를 써주세요."
            return false
        }

        return true
    }
}