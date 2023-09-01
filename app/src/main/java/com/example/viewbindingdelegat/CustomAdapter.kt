package com.example.viewbindingdelegat

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(
    private var items: MutableList<String>
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    var visibily = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textViewLarge)
        val liner: LinearLayout = view.findViewById(R.id.contener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position]
        Log.d("TEST", "onBindViewHolder")
    }

    override fun getItemCount() = items.size

    fun setData(newList:MutableList<String>){
        val diffUtil = DiffCallback(items,newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        items.clear()
        items.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }
}