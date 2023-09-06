package com.example.viewbindingdelegat

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexboxLayoutManager


class CustomAdapter(
    private var items: MutableList<String>
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textViewLarge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("TEST", "onBindViewHolder")
        holder.textView.text = items[position]
        val lp: ViewGroup.LayoutParams = holder.itemView.layoutParams
        if (lp is FlexboxLayoutManager.LayoutParams) {
            val flexboxLp = lp
            flexboxLp.flexShrink = 0.0f
            flexboxLp.alignSelf =
                AlignItems.FLEX_START //this will align each itemView on Top or use AlignItems.FLEX_END to align it at Bottom
        }
    }

    override fun getItemCount() = items.size

    fun setData(newList:MutableList<String>){
        val diffUtil = DiffCallback(items,newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        items = newList
        diffResult.dispatchUpdatesTo(this)
    }
}