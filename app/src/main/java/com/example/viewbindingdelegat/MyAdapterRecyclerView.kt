package com.example.viewbindingdelegat

import android.graphics.Canvas
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MyAdapterRecyclerView(
    private val items: MutableList<String>,
    private val linearLayoutManager: LinearLayoutManager,
    private val recyclerView: RecyclerView
    ) : RecyclerView.Adapter<MyAdapterRecyclerView.ViewHolder>() {

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
    }

    override fun getItemCount() = items.size
}

class HideLastDecorator(private var dataList:MutableList<String>) : RecyclerView.ItemDecoration() {
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        val count = parent.childCount
        for (i in 0 until count) {
            val currentChild = parent.getChildAt(i)
            if (parent.layoutManager?.isViewPartiallyVisible(currentChild, true, false) == false) {
                currentChild.visibility =View.GONE
            }
        }

        val g = (parent.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition() + 1
        val iu = dataList[(parent.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()]
        if (g != dataList.count()) {
            /*dataList[count - 2] = "+${dataList.count() - (count - 2)}"
            parent.adapter?.notifyItemChanged(count - 2)*/
            dataList = dataList.slice(0..g-2).toMutableList()
            parent.adapter?.notifyDataSetChanged()
            parent.removeItemDecorationAt(0)
        }
    }
}