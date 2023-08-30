package com.example.viewbindingdelegat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.viewbindingdelegat.databinding.ActivityErrorBinding
import com.google.android.flexbox.*

class ErrorActivity : AppCompatActivity(R.layout.activity_error) {

    val binding by viewBinding(ActivityErrorBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataList = fillList().toMutableList()

        binding.rvError.apply {
            layoutManager = FlexboxLayoutManager(this@ErrorActivity).apply {
                flexWrap = FlexWrap.WRAP
                flexDirection = FlexDirection.ROW
                justifyContent = JustifyContent.FLEX_START
            }
            adapter = MyAdapterErrorRecyclerView(dataList)
        }

    }

    private fun fillList(): List<String> {
        val data = mutableListOf<String>()
        (0..3000).forEach { i -> data.add("${i*i} element") }
        return data
    }
}