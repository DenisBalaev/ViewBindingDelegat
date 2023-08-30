package com.example.viewbindingdelegat

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.viewbindingdelegat.databinding.ActivityMainBinding
import com.google.android.flexbox.*


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

        /*startActivity(Intent(this,ErrorActivity::class.java))
        finish()*/

        val dataList = fillList().toMutableList()
        val li = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)

        binding.rvError.apply {
            adapter = MyAdapterRecyclerView(dataList,li,this)
            layoutManager = li
            addItemDecoration(HideLastDecorator(dataList))
        }
    }

    private fun fillList(): List<String> {
        val data = mutableListOf<String>()
        (1..50).forEach { i -> data.add("${i*i} element") }
        return data
    }
}