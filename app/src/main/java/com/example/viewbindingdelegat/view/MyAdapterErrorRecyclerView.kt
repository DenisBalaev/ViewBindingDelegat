package com.example.viewbindingdelegat.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbindingdelegat.R

class MyAdapterErrorRecyclerView(private val items: List<String>) : RecyclerView.Adapter<MyAdapterErrorRecyclerView.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textViewLarge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.textView.text = item
        /*val co = if (position == 0) 1 else layoutManager.findLastCompletelyVisibleItemPosition()
        if (position == co) {
            holder.textView.text = "+${items.size - position}"
        }*/
    }

    override fun getItemCount() = items.size
}