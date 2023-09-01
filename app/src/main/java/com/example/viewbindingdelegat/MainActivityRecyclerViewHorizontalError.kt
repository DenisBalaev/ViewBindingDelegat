package com.example.viewbindingdelegat

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.viewbindingdelegat.databinding.ActivityMainRecyclerViewHorizontalErrorBinding


class MainActivityRecyclerViewHorizontalError : AppCompatActivity(R.layout.activity_main_recycler_view_horizontal_error) {
    private val binding by viewBinding(ActivityMainRecyclerViewHorizontalErrorBinding::bind)

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dataList = fillList().toMutableList()
        val layoutManagers = LinearLayoutManager(this@MainActivityRecyclerViewHorizontalError,LinearLayoutManager.HORIZONTAL,false)
        val adapters = CustomAdapter(dataList)
        binding.rv.apply {
            layoutManager = layoutManagers
            adapter = adapters
            post {
                val lastVisibleItem =layoutManagers.findLastCompletelyVisibleItemPosition()
                Log.d("TEST", "LastItem: $lastVisibleItem")
                adapters.visibily = lastVisibleItem + 1
                dataList[lastVisibleItem] = (dataList.size - lastVisibleItem).toString()
                this.adapter?.notifyDataSetChanged()
            }
        }
    }

    private fun fillList(): List<String> {
        val data = mutableListOf<String>()
        (0..10).forEach { i -> data.add("$i elqq") }
        return data
    }
}