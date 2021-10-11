package com.example.studydiary.Activity.Write

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.studydiary.R
import com.example.studydiary.databinding.ActivityWriteBinding

class WriteActivity : AppCompatActivity() {
    lateinit var binding : ActivityWriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_write)
    }
}