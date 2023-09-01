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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivityRecyclerViewHorizontalError : AppCompatActivity(R.layout.activity_main_recycler_view_horizontal_error) {
    private val binding by viewBinding(ActivityMainRecyclerViewHorizontalErrorBinding::bind)

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        var dataList = fillList().toMutableList()
        val layoutManagers = LinearLayoutManager(this@MainActivityRecyclerViewHorizontalError,LinearLayoutManager.HORIZONTAL,false)
        val adapters = CustomAdapter(dataList)

        val addListenerDiffUtil = object : View.OnLayoutChangeListener{
            override fun onLayoutChange(v: View?, left: Int, top: Int, right: Int, bottom: Int, oldLeft: Int, oldTop: Int, oldRight: Int, oldBottom: Int) {
                val lastVisibleItem: Int = layoutManagers.findLastCompletelyVisibleItemPosition()
                if (lastVisibleItem > 0) {
                    Log.d("TEST", "LastItem: $lastVisibleItem")
                    val count = (dataList.size - lastVisibleItem).toString()
                    dataList = dataList.toMutableList().slice(0..lastVisibleItem).toMutableList().apply {
                        this[lastVisibleItem] = count
                    }
                    binding.rv.removeOnLayoutChangeListener(this);
                    binding.rv.apply {
                        itemAnimator = null
                        post{adapters.setData(dataList)}
                    }
                }
            }

        }

        binding.rv.apply {
            layoutManager = layoutManagers
            adapter = adapters
            addOnLayoutChangeListener(addListenerDiffUtil)
        }


        /*binding.rv.post {
            val lastVisibleItem =layoutManagers.findLastCompletelyVisibleItemPosition()
            Log.d("TEST", "LastItem: $lastVisibleItem")
            adapters.visibily = lastVisibleItem + 1
            dataList[lastVisibleItem] = (dataList.size - lastVisibleItem).toString()
            this.binding.rv.adapter?.notifyDataSetChanged()
        }*/
    }

    private fun fillList(): List<String> {
        val data = mutableListOf<String>()
        (0..10).forEach { i -> data.add("$i elqqk") }
        return data
    }
}