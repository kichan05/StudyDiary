package com.example.studydiary.Activity.DiaryDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.studydiary.Model.Diary
import com.example.studydiary.R
import com.example.studydiary.databinding.ActivityDiaryDetailBinding

class DiaryDetail : AppCompatActivity() {
    lateinit var binding : ActivityDiaryDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_diary_detail)

        val diary = intent.getSerializableExtra("diary") as Diary

        with(binding){
            txtDiaryDetailSubject.text = diary.subject
            txtDiaryDetailMethod.text = diary.method
            txtDiaryDetailDiaryContent.text = diary.content
        }

    }
}