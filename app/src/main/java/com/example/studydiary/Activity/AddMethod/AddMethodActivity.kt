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

        val subjectList = resources.getStringArray(R.array.subjects)
        val choiceSubjectAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, subjectList)
        binding.spinnerAddMethodChoiceSubject.adapter = choiceSubjectAdapter


        binding.spinnerAddMethodChoiceSubject.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 == subjectList.size - 1){
                    val intent = Intent(this@AddMethodActivity, AddSubjectActivity::class.java)
                    startActivity(intent)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }
}