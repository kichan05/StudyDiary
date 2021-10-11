package com.example.studydiary.Fragment.Write

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.studydiary.R
import com.example.studydiary.databinding.FragmentWriteBinding

class WriteFragment : Fragment() {
    lateinit var binding : FragmentWriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_write, container, false)
        val root = binding.root




        return root
    }
}