package com.example.studydiary.Activity.AddSubject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.studydiary.Activity.Splash.subjectDB
import com.example.studydiary.DB.Method.MethodDatabase
import com.example.studydiary.DB.Subject.SubjectDatabase
import com.example.studydiary.Model.Subject
import com.example.studydiary.R
import com.example.studydiary.databinding.ActivityAddSubjectBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddSubjectActivity : AppCompatActivity() {
    lateinit var binding : ActivityAddSubjectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_subject)

        binding.btnAddSubjectAddBtn.setOnClickListener {
            val inputSubject = binding.edtAddSubjectInputSubject.text.toString()

            CoroutineScope(Dispatchers.IO).launch {
                subjectDB.subjectDao().insert(
                    Subject(subject_name = inputSubject)
                )

                finish()
            }
        }
    }
}