package com.example.studydiary.Activity.AddMethod

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.studydiary.Activity.AddSubject.AddSubjectActivity
import com.example.studydiary.Activity.Splash.methodDB
import com.example.studydiary.Activity.Splash.subjectDB
import com.example.studydiary.Model.Method
import com.example.studydiary.Model.Subject
import com.example.studydiary.R
import com.example.studydiary.databinding.ActivityAddMethodBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddMethodActivity : AppCompatActivity() {
    lateinit var binding : ActivityAddMethodBinding
    lateinit var subjectList : MutableList<Subject>
    lateinit var subject : String
    lateinit var methodName : String
    lateinit var methodEx : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_method)


        with(binding){
            //과목 선택창 설정
            CoroutineScope(Dispatchers.IO).launch{
                subjectList = subjectDB.subjectDao().getAll().toMutableList()
                subjectList.add(0, Subject(subject_name = "과목을 선택해주세요."))
                subjectList.add(Subject(subject_name = "과목 추가하기"))
                val choiceSubjectAdapter = ArrayAdapter(this@AddMethodActivity, android.R.layout.simple_spinner_dropdown_item, subjectList)
                spinnerAddMethodChoiceSubject.adapter = choiceSubjectAdapter
            }
            spinnerAddMethodChoiceSubject.onItemSelectedListener = this@AddMethodActivity.choiceSubjectChanged

            
            
            // 완료버튼을 눌었을때
            btnAddMethodAddMethod.setOnClickListener {
                methodName = edtAddMethodInputName.text.toString()
                methodEx = edtAddMethodInputEx.text.toString()
                if (!inoutEmptyCheck()) return@setOnClickListener

                CoroutineScope(Dispatchers.IO).launch{
                    methodDB.methodDao().insert(Method(name = methodName, explanation = methodEx, subject = subject))
                    finish()
                }
            }
        }
    }

    private fun inoutEmptyCheck(): Boolean {
        with(binding){
            if(subject == "과목을 선택해주세요." || subject == "과목 추가하기"){
                Toast.makeText(this@AddMethodActivity, "과목을 선택해주세요.", Toast.LENGTH_LONG).show()
                return false
            }
            if(methodName.isEmpty()){
                edtAddMethodInputName.error = "공부법 이름을 입력력하세요."
                return false
            }
            if(methodEx.isEmpty()){
                edtAddMethodInputEx.error = "공부법 설명을 입력력하세요."
                return false
            }
        }

        return true
    }

    val choiceSubjectChanged = object : AdapterView.OnItemSelectedListener{
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            if(p2 == subjectList.size - 1){
                val intent = Intent(this@AddMethodActivity, AddSubjectActivity::class.java)
                startActivity(intent)
            }   else{
                subject = subjectList[p2].subject_name
            }
        }
        override fun onNothingSelected(p0: AdapterView<*>?) {}
    }
}