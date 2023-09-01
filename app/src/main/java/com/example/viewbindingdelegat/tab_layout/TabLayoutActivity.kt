package com.example.viewbindingdelegat.tab_layout

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.viewbindingdelegat.R
import com.example.viewbindingdelegat.databinding.ActivityTabLayoutBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator


class TabLayoutActivity : AppCompatActivity(R.layout.activity_tab_layout) {

    val binding by viewBinding(ActivityTabLayoutBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tabLayout = binding.tabLayout
        val viewPager2 = binding.viewPage

        val adapter = MyFragmentAdapter(supportFragmentManager,lifecycle).apply {
            addFragment(SignUpFragment(),"UP 1")
            addFragment(SignInFragment(),"IN 1")
            addFragment(SignUpFragment(),"UP 1")
            addFragment(SignInFragment(),"IN 1")
            addFragment(SignUpFragment(),"UP 1")
            addFragment(SignInFragment(),"IN 1")
            addFragment(SignUpFragment(),"UP 1")
            addFragment(SignInFragment(),"IN 1")
        }

        viewPager2.adapter = adapter

        TabLayoutMediator(tabLayout,viewPager2){tab,position->
            tab.text = adapter.titleList[position]
        }.attach()

        repeat(adapter.titleList.size){
            val textView = LayoutInflater.from(this).inflate(R.layout.item_title_tab_layout,null) as TextView
            tabLayout.getTabAt(it)!!.customView = textView
        }

        viewPager2.currentItem = 1
    }
}