package com.example.studydiary.Activity.AddSubject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.studydiary.R
import com.example.studydiary.databinding.ActivityAddSubjectBinding

class AddSubjectActivity : AppCompatActivity() {
    lateinit var binding : ActivityAddSubjectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_subject)

        binding.btnAddSubjectAddBtn.setOnClickListener {
            Toast.makeText(this, "과목을 추가하였습니다.", Toast.LENGTH_LONG).show()
        }
    }
}