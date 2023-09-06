package com.example.viewbindingdelegat.bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.viewbindingdelegat.CustomAdapter
import com.example.viewbindingdelegat.R
import com.example.viewbindingdelegat.bottomsheet.new.NewBottom
import com.example.viewbindingdelegat.bottomsheet.new.NewBottom2
import com.example.viewbindingdelegat.databinding.ActivityBottomSheetBinding
import com.example.viewbindingdelegat.databinding.ActivityMainBinding.bind
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.google.android.material.bottomsheet.BottomSheetDialog

class BottomSheetActivity : AppCompatActivity(R.layout.activity_bottom_sheet) {
    private val binding by viewBinding(ActivityBottomSheetBinding::bind)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*val dataList3 = fillList().toMutableList()
        val adapters3 = CustomAdapter(dataList3)

        binding.rvCommand.apply {
            layoutManager = FlexboxLayoutManager(this@BottomSheetActivity).apply {
                flexWrap = FlexWrap.WRAP
                flexDirection = FlexDirection.ROW
                justifyContent = JustifyContent.FLEX_START
            }
            adapter = adapters3
        }*/

        //val newBottom = NewBottom(this,layoutInflater)
        binding.btn.setOnClickListener {
            val bottom = NewBottom(context = this, layoutInflater = layoutInflater)
            bottom.show()
            //newBottom.show()
        }
    }

    private fun fillList(): List<String> {
        val data = mutableListOf<String>()
        (0..100).forEach { i -> data.add("$i ek444") }
        return data
    }
}