package com.example.studydiary.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.studydiary.Activity.Splash.methodDB
import com.example.studydiary.Activity.Splash.subjectDB
import com.example.studydiary.R

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        view?.findViewById<Button>(R.id.btnsss)?.setOnClickListener {
            methodDB.methodDao().clearAll()
            subjectDB.subjectDao().clearAll()
        }

        return inflater.inflate(R.layout.fragment_main, container, false)
    }
}