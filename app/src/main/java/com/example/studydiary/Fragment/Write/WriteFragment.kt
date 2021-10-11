package com.example.studydiary.Fragment.Write

import android.content.Intent
import android.os.Bundle
import android.text.style.LineHeightSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.studydiary.Activity.AddSubject.AddSubjectActivity
import com.example.studydiary.Activity.Splash.methodDB
import com.example.studydiary.Activity.Splash.subjectDB
import com.example.studydiary.Activity.Write.WriteActivity
import com.example.studydiary.Model.Diary
import com.example.studydiary.Model.Method
import com.example.studydiary.Model.Subject
import com.example.studydiary.R
import com.example.studydiary.databinding.FragmentWriteBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WriteFragment : Fragment() {
    lateinit var binding : FragmentWriteBinding
    var focusScore = 0
    var abilityScore = 0
    var subject = ""
    var method = ""
    lateinit var subjectList : MutableList<Subject>
    lateinit var methodList : MutableList<Method>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_write, container, false)
        val root = binding.root

        with(binding){
            seekWriteAbility.setOnSeekBarChangeListener(seekBar)
            seekWriteFocus.setOnSeekBarChangeListener(seekBar)


            btnWriteNext.setOnClickListener {
                if(!inputEmptyCheck()) {
                    return@setOnClickListener
                }

                val intent = Intent(requireContext(), WriteActivity::class.java)
                intent.putExtra("diary", Diary(
                    focus = focusScore,
                    ability = abilityScore,
                    subject = subject,
                    method = method,
                ))
                root.context.startActivity(intent)
            }
        }

        CoroutineScope(Dispatchers.IO).launch{
            subjectList = subjectDB.subjectDao().getAll().toMutableList()
            subjectList.add(0, Subject(subject_name = "과목을 선택해주세요."))
            subjectList.add(Subject(subject_name = "과목 추가하기"))

            val choiceSubjectAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, subjectList)
            withContext(Dispatchers.Main){
                binding.spinnerWriteChoiceSubject.adapter = choiceSubjectAdapter
            }
        }
        binding.spinnerWriteChoiceSubject.onItemSelectedListener = choiceSubjectChanged
        binding.spinnerWriteChoiceMethod.onItemSelectedListener = choiceMethodChanged


        return root
    }

    val seekBar = object : SeekBar.OnSeekBarChangeListener{
        override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
            if(p0?.id == R.id.seek_write_ability){
                binding.txtWriteAbilityScore.text = "${p1}점"
            }   else if(p0?.id == R.id.seek_write_focus){
                binding.txtWriteFocusScore.text = "${p1}점"
            }
        }

        override fun onStartTrackingTouch(p0: SeekBar?) {}

        override fun onStopTrackingTouch(p0: SeekBar?) {
            if(p0?.id == R.id.seek_write_ability){
                abilityScore = p0.progress
            }   else if(p0?.id == R.id.seek_write_focus){
                focusScore = p0.progress
            }
        }
    }

    val choiceSubjectChanged = object : AdapterView.OnItemSelectedListener{
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            if (p2 == subjectList.size - 1){
                val intent = Intent(requireContext(), AddSubjectActivity::class.java)
                startActivity(intent)
            }   else{
                subject = subjectList[p2].subject_name
                CoroutineScope(Dispatchers.IO).launch {
                    methodList = methodDB.methodDao().getSubject(subject).toMutableList()
                    methodList.add(0, Method(name = "공부법을 선택해주세요.", subject = subject, explanation = ""))
                    withContext(Dispatchers.Main){
                        binding.spinnerWriteChoiceMethod.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, methodList)
                    }
                }
            }
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {}
    }

    val choiceMethodChanged = object : AdapterView.OnItemSelectedListener{
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            if(p2 != 0){
                method = methodList[p2].name
            }
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {}
    }

    fun inputEmptyCheck(): Boolean {
        if(subject.isEmpty()){
            Toast.makeText(requireContext(), "과목을 선택해주세요.", Toast.LENGTH_LONG).show()
            return false
        }
        if(method.isEmpty()){
            Toast.makeText(requireContext(), "공부법을 선택해주세요.", Toast.LENGTH_LONG).show()
            return false
        }

        return true
    }
}