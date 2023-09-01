package com.example.viewbindingdelegat.status

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbindingdelegat.R

class AdapterStatus(
    private val items:List<StatusModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ViewHolderError(val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tv)
        val recyclerView: RecyclerView = view.findViewById(R.id.rvError)

        fun bind(){

        }
    }

    class ViewHolderGeneral(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(){

        }
    }

    class ViewHolderHeader(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(){

        }
    }

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_CARD = 1
        private const val TYPE_ERROR = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when(items[position]){
            is ItemHeaderStatusModel-> {
                TYPE_HEADER}
            is ItemCardErrorModel-> {
                TYPE_ERROR
            }
            else -> {
                TYPE_CARD
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            TYPE_CARD ->{
                ViewHolderGeneral(LayoutInflater.from(parent.context).inflate(R.layout.item_car_status, parent, false))
            }
            TYPE_ERROR ->{
                ViewHolderError(LayoutInflater.from(parent.context).inflate(R.layout.item_error_recyclerview_status, parent, false))
            }
            else ->{
                ViewHolderHeader(LayoutInflater.from(parent.context).inflate(R.layout.item_header_status, parent, false))
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount() = items.size
}