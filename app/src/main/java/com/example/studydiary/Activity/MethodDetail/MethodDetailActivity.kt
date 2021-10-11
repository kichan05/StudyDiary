package com.example.studydiary.Activity.MethodDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.studydiary.Model.Method
import com.example.studydiary.R
import com.example.studydiary.databinding.ActivityMethodDetailBinding

class MethodDetailActivity : AppCompatActivity() {
    lateinit var binding : ActivityMethodDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_method_detail)

        val method = intent.getSerializableExtra("method") as Method

        with(binding){
            txtMethodDetailTitle.text = method.name
            txtMethodDetailSubject.text = method.subject
            txtMethodDetailEx.text = method.explanation
        }
    }
}