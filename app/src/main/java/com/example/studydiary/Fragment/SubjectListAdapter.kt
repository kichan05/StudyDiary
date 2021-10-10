package com.example.studydiary.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studydiary.Model.Subject
import com.example.studydiary.R

class SubjectListAdapter(val items : MutableList<Subject>) : RecyclerView.Adapter<SubjectListAdapter.Holder>() {
    class Holder(val view : View) : RecyclerView.ViewHolder(view) {
        val subject = view.findViewById<TextView>(R.id.txt_subjectListItem_subject)

//        companion object{
//            fun from(parenr : ViewGroup) : Holder{
//                return Holder(Lay)
//            }
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.subject_list_item, parent, false)

        return Holder(layout)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.subject.text = items[position].subject_name
    }

    override fun getItemCount(): Int {
        return items.size
    }
}