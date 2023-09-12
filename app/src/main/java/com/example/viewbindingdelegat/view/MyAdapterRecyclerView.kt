package com.example.viewbindingdelegat.view

import android.graphics.Canvas
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbindingdelegat.DiffCallback
import com.example.viewbindingdelegat.R


class MyAdapterRecyclerView(
    private var items: MutableList<String>
    ) : RecyclerView.Adapter<MyAdapterRecyclerView.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textViewLarge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position]
        if (isUpdatingSetData){
            isUpdating = true
        }
    }

    override fun getItemCount() = items.size

    fun setData(newList:MutableList<String>){
        val diffUtil = DiffCallback(items,newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        items = newList
        diffResult.dispatchUpdatesTo(this)
        isUpdatingSetData = true
    }

    private var isUpdatingSetData = false
    var isUpdating = false
}