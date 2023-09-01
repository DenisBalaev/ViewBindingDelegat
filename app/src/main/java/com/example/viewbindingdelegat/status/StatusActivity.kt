package com.example.viewbindingdelegat.status

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.viewbindingdelegat.R
import com.example.viewbindingdelegat.databinding.ActivityStatusBinding

class StatusActivity : AppCompatActivity(R.layout.activity_status) {
    private val binding by viewBinding(ActivityStatusBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val list = mutableListOf<StatusModel>()

        binding.rvStatus.apply {
            layoutManager = LinearLayoutManager(this@StatusActivity)
            adapter = AdapterStatus(list)
        }
    }
}