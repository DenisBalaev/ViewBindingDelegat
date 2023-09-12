package com.example.viewbindingdelegat.view

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.viewbindingdelegat.MainActivityRecyclerViewHorizontalError
import com.example.viewbindingdelegat.R
import com.example.viewbindingdelegat.bottomsheet.BottomSheetActivity
import com.example.viewbindingdelegat.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding by viewBinding(ActivityMainBinding::bind)
    private var indexLastVisibleItemPosition = 0
    override fun onStart() {
        super.onStart()

        val dataList = fillList().toMutableList()
        val li = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL,false)

        binding.rvError.apply {
            adapter = MyAdapterRecyclerView(dataList)
            layoutManager = li
        }

        val layoutManagerError = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL,false)
        val layoutManagerError2 = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL,false)

        binding.rvError3.apply {
            adapter = MyAdapterRecyclerView(dataList)
            layoutManager = layoutManagerError2
            addOnLayoutChangeListener(object : View.OnLayoutChangeListener{
                override fun onLayoutChange(v: View?, left: Int, top: Int, right: Int, bottom: Int, oldLeft: Int, oldTop: Int, oldRight: Int, oldBottom: Int) {
                    val lastVisibleItem: Int = layoutManagerError2.findLastVisibleItemPosition()
                    if (lastVisibleItem > 0) {
                        val count = "+${dataList.size - lastVisibleItem}"
                        val newDate = dataList.toMutableList().slice(0..lastVisibleItem).toMutableList().apply {
                            this[lastVisibleItem] = count
                        }

                        binding.rvError3.removeOnLayoutChangeListener(this);
                        binding.rvError3.apply {
                            itemAnimator = null
                            post{(this.adapter as MyAdapterRecyclerView).setData(newDate)}
                        }
                    }
                }
            })
        }

        val adapters = MyAdapterRecyclerView(dataList)

        binding.rvError2.apply {
            adapter = adapters
            layoutManager = layoutManagerError
            addOnLayoutChangeListener(object : View.OnLayoutChangeListener{
                override fun onLayoutChange(v: View?, left: Int, top: Int, right: Int, bottom: Int, oldLeft: Int, oldTop: Int, oldRight: Int, oldBottom: Int) {
                    val lastVisibleItem: Int = layoutManagerError.findLastVisibleItemPosition()
                    val lastVisibleItemCompletely: Int = layoutManagerError.findLastCompletelyVisibleItemPosition()
                    indexLastVisibleItemPosition = lastVisibleItem
                    if (lastVisibleItem > 0 && lastVisibleItemCompletely < dataList.size - 1 && lastVisibleItem != lastVisibleItemCompletely) {
                        update(dataList, lastVisibleItem)
                    }

                    binding.rvError2.removeOnLayoutChangeListener(this);
                }
            })

            addOnLayoutChangeListener(object : View.OnLayoutChangeListener{
                override fun onLayoutChange(v: View?, left: Int, top: Int, right: Int, bottom: Int, oldLeft: Int, oldTop: Int, oldRight: Int, oldBottom: Int) {
                    if (adapters.isUpdating){
                        val lastVisibleItemComplete: Int = layoutManagerError.findLastCompletelyVisibleItemPosition()
                        if (lastVisibleItemComplete in 1 until indexLastVisibleItemPosition) {
                            update(dataList, lastVisibleItemComplete)
                        }

                        binding.rvError2.removeOnLayoutChangeListener(this);
                    }
                }
            })
        }
    }

    private fun update(dataList:MutableList<String>,lastVisibleItem:Int){
        val count = "+${dataList.size - lastVisibleItem}"
        val newDate = dataList.toMutableList().slice(0..lastVisibleItem).toMutableList().apply {
            this[lastVisibleItem] = count
        }
        binding.rvError2.apply {
            itemAnimator = null
            post{(this.adapter as MyAdapterRecyclerView).setData(newDate)}
        }
    }

    private fun fillList(): List<String> {
        val data = mutableListOf<String>()
        (0..10).forEach { i -> data.add("$i eleeee") }
        return data
    }
}