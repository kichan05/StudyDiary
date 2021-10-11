package com.example.studydiary.Fragment.SubjectList

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studydiary.Activity.MethodDetail.MethodDetailActivity
import com.example.studydiary.Model.Method
import com.example.studydiary.R

class MethodListAdapter(private val items : MutableList<Method>) : RecyclerView.Adapter<MethodListAdapter.Holder>(){
    class Holder(val view : View) : RecyclerView.ViewHolder(view){
        val method = view.findViewById<TextView>(R.id.txt_methodList_method)

        companion object{
            fun from(parent: ViewGroup) : Holder {
                return Holder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.method_list_item, parent, false))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder.from(parent)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        with(holder.view){
            holder.method.text = items[position].name
            setOnClickListener {
                val intent = Intent(context, MethodDetailActivity::class.java)
                intent.putExtra("method", items[position])
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}