package com.example.studydiary.Fragment.SubjectList

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studydiary.Activity.Splash.methodDB
import com.example.studydiary.Model.Subject
import com.example.studydiary.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SubjectListAdapter(val items : MutableList<Subject>) : RecyclerView.Adapter<SubjectListAdapter.Holder>() {
    class Holder(val view : View) : RecyclerView.ViewHolder(view) {
        val subject = view.findViewById<TextView>(R.id.txt_subjectListItem_subject)
        val methodRecycler = view.findViewById<RecyclerView>(R.id.recycler_subjectListItem_methodList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.subject_list_item, parent, false)
        return Holder(layout)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.subject.text = items[position].subject_name

        CoroutineScope(Dispatchers.IO).launch {
            val methodList = methodDB.methodDao().getSubject(items[position].subject_name).toMutableList()
            Log.d("methodList", methodList.toString())
//            if(methodList.size > 0){
            withContext(Dispatchers.Main){
                val methodListAdapter = MethodListAdapter(methodList)
                holder.methodRecycler.adapter = methodListAdapter
            }
//            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}