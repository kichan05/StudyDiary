package com.example.studydiary.Fragment.Main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studydiary.Activity.DiaryDetail.DiaryDetail
import com.example.studydiary.Model.Diary
import com.example.studydiary.R

class DiaryListAdapter(private val items : MutableList<Diary>) :
    RecyclerView.Adapter<DiaryListAdapter.Holder>() {
    class Holder(val view : View) : RecyclerView.ViewHolder(view){
        val subject = view.findViewById<TextView>(R.id.txt_diaryList_subject)
        val method = view.findViewById<TextView>(R.id.txt_diaryList_method)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.diary_list_item, parent, false)
        return Holder(layout)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.subject.text = items[position].subject
        holder.method.text = items[position].method

        holder.view.setOnClickListener {
            val intent = Intent(holder.view.context, DiaryDetail::class.java)
            intent.putExtra("diary", items[position])

            holder.view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}