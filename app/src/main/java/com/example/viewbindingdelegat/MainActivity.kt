package com.example.viewbindingdelegat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.viewbindingdelegat.databinding.ActivityMainBinding
import com.example.viewbindingdelegat.status.StatusActivity
import com.example.viewbindingdelegat.tab_layout.TabLayoutActivity


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    //private lateinit var binding: ActivityMainBinding
    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onStart() {
        super.onStart()
        /*val yourItemsList = arrayOf("Сначала ближайшие", "Сначала дальние", "Рабочие", "Неисправные").toList()
        val spinner = binding.spinner
        val adapter = CustomSpinnerAdapter(
            this,
            R.layout.spinner_item,
            yourItemsList,
            R.drawable.ic_tick_bottom
        )
        spinner.adapter = adapter*/

        startActivity(Intent(this, MainActivityRecyclerViewHorizontalError::class.java))
        finish()

        /*val dataList = fillList().toMutableList()
        val li = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)

        binding.rvError.apply {
            adapter = MyAdapterRecyclerView(dataList,li,this)
            layoutManager = li
            addItemDecoration(HideLastDecorator(dataList))
        }*/
    }

    private fun fillList(): List<String> {
        val data = mutableListOf<String>()
        (0..10).forEach { i -> data.add("$i elqq") }
        return data
    }
}