package com.example.studydiary.Fragment.Main

import android.database.CrossProcessCursor
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.studydiary.Activity.Splash.diaryDB
import com.example.studydiary.Activity.Splash.methodDB
import com.example.studydiary.Activity.Splash.subjectDB
import com.example.studydiary.Fragment.SubjectList.MethodListAdapter
import com.example.studydiary.R
import com.example.studydiary.databinding.FragmentMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate

class MainFragment : Fragment() {
    lateinit var binding : FragmentMainBinding
    override fun onCreateView(
        inflater:LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        val root = binding.root

        val nowDate = LocalDate.now()
        CoroutineScope(Dispatchers.Main).launch {
            showTodoList(nowDate.year, nowDate.monthValue, nowDate.dayOfMonth)
        }

        binding.calendarMainCalendar.setOnDateChangeListener{ view, year, month, day ->
            CoroutineScope(Dispatchers.Main).launch {
                showTodoList(year, month + 1, day)
            }
        }



        return root
    }

    suspend fun showTodoList(year : Int, month : Int, day : Int){
        Log.d("diaryList", "$year, $month, $day")
        CoroutineScope(Dispatchers.IO).launch {
            val diaryList = diaryDB.diaryDao().getDay(year, month, day).toMutableList()
            withContext(Dispatchers.Main){
                if(diaryList.size == 0){
                    binding.txtMainListNullMSG.visibility = View.VISIBLE
                    binding.txtMainListNullMSG.text = "${month}월 ${day}일은 일기가 없습니다."
                }   else{
                    binding.txtMainListNullMSG.visibility = View.INVISIBLE
                }
                binding.recyclerMainDiaryList.adapter = DiaryListAdapter(diaryList)
            }
        }
    }
}