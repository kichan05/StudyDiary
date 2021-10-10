package com.example.studydiary.Activity.AddMethod

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import com.example.studydiary.Activity.AddSubject.AddSubjectActivity
import com.example.studydiary.R
import com.example.studydiary.databinding.ActivityAddMethodBinding

class AddMethodActivity : AppCompatActivity() {
    lateinit var binding : ActivityAddMethodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_method)


    }
}