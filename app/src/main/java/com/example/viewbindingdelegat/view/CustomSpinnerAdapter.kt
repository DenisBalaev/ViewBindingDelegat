package com.example.viewbindingdelegat.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.viewbindingdelegat.R


class CustomSpinnerAdapter(
    context: Context,
    resource: Int,
    items: List<String?>?,
    private val spinnerIcon: Int
) :
    ArrayAdapter<String?>(context, resource, items!!) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createItemView(position, parent)
    }

    private fun createItemView(position: Int, parent: ViewGroup): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.spinner_item, parent, false)
        val text = view.findViewById<View>(R.id.text) as TextView
        val icon = view.findViewById<View>(R.id.icon) as ImageView
        text.text = getItem(position)

        // You can change the icon for each item here
        icon.setImageResource(spinnerIcon)
        return view
    }
}