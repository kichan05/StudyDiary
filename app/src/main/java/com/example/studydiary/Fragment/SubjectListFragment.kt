package com.example.studydiary.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.example.studydiary.Activity.AddMethod.AddMethodActivity
import com.example.studydiary.Activity.AddSubject.AddSubjectActivity
import com.example.studydiary.R
import com.example.studydiary.databinding.FragmentSubjectListBinding

class SubjectListFragment : Fragment() {
    lateinit var binding : FragmentSubjectListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_subject_list, container, false)
        val root = binding.root

        binding.floatingBtnSubjectListAddMethod.setOnClickListener{
            val intent = Intent(requireContext(), AddMethodActivity::class.java)
            startActivity(intent)
        }

        return root
    }
}