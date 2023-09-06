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
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivityRecyclerViewHorizontalError : AppCompatActivity(R.layout.activity_main_recycler_view_horizontal_error) {
    private val binding by viewBinding(ActivityMainRecyclerViewHorizontalErrorBinding::bind)

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        var dataList = fillList().toMutableList()
        val layoutManagerError = LinearLayoutManager(this@MainActivityRecyclerViewHorizontalError,LinearLayoutManager.HORIZONTAL,false)
        val adapters = CustomAdapter(dataList)

        binding.rv.apply {
            layoutManager = layoutManagerError
            adapter = adapters
            addOnLayoutChangeListener(object : View.OnLayoutChangeListener{
                override fun onLayoutChange(v: View?, left: Int, top: Int, right: Int, bottom: Int, oldLeft: Int, oldTop: Int, oldRight: Int, oldBottom: Int) {
                    val lastVisibleItem: Int = layoutManagerError.findLastVisibleItemPosition()
                    if (lastVisibleItem > 0) {
                        val count = "+${dataList.size - lastVisibleItem}"
                        dataList = dataList.toMutableList().slice(0..lastVisibleItem).toMutableList().apply {
                            this[lastVisibleItem] = count
                        }

                        binding.rv.removeOnLayoutChangeListener(this);
                        binding.rv.apply {
                            itemAnimator = null
                            post{(this.adapter as CustomAdapter).setData(dataList)}
                        }
                    }
                }
            })
        }

        var dataList2 = fillList().toMutableList()
        val layoutManagerError2 = LinearLayoutManager(this@MainActivityRecyclerViewHorizontalError,LinearLayoutManager.HORIZONTAL,false)
        val adapters2 = CustomAdapter(dataList2)

        binding.rv2.apply {
            layoutManager = layoutManagerError2
            adapter = adapters2
            addOnLayoutChangeListener(object : View.OnLayoutChangeListener{
                override fun onLayoutChange(v: View?, left: Int, top: Int, right: Int, bottom: Int, oldLeft: Int, oldTop: Int, oldRight: Int, oldBottom: Int) {
                    val lastVisibleItem: Int = layoutManagerError2.findLastCompletelyVisibleItemPosition()
                    if (lastVisibleItem > 0) {
                        val count = "+${dataList2.size - lastVisibleItem}"
                        dataList2 = dataList2.toMutableList().slice(0..lastVisibleItem).toMutableList().apply {
                            this[lastVisibleItem] = count
                        }

                        binding.rv2.removeOnLayoutChangeListener(this);
                        binding.rv2.apply {
                            itemAnimator = null
                            post{(this.adapter as CustomAdapter).setData(dataList2)}
                        }
                    }
                }
            })
        }

        val dataList3 = fillList().toMutableList()
        val layoutManagerError3 = LinearLayoutManager(this@MainActivityRecyclerViewHorizontalError,LinearLayoutManager.HORIZONTAL,false)
        val adapters3 = CustomAdapter(dataList3)

        binding.rv3.apply {
            layoutManager = layoutManagerError3
            adapter = adapters3
            /*addOnLayoutChangeListener(object : View.OnLayoutChangeListener{
                override fun onLayoutChange(v: View?, left: Int, top: Int, right: Int, bottom: Int, oldLeft: Int, oldTop: Int, oldRight: Int, oldBottom: Int) {
                    val lastVisibleItem: Int = layoutManagerError3.findLastVisibleItemPosition()

                    if (lastVisibleItem > 0) {
                        val count = (dataList3.size - lastVisibleItem)
                        dataList3 = dataList3.toMutableList().slice(0..lastVisibleItem).toMutableList().apply {
                            this[lastVisibleItem] = count.toString()
                        }
                        val li = this
                        binding.rv3.apply {
                            post {
                                adapters3.setData(dataList3)
                                val lastVisibleItemComp: Int = layoutManagerError3.findLastCompletelyVisibleItemPosition()
                                if (lastVisibleItem != lastVisibleItemComp){
                                    binding.rv3.removeOnLayoutChangeListener(li);
                                    dataList3 = dataList3.toMutableList().slice(0..lastVisibleItemComp).toMutableList().apply {
                                        this[lastVisibleItemComp] = "+"+(count + 1).toString()
                                    }
                                    adapters3.setData(dataList3)
                                }
                            }
                        }
                    }
                }
            })*/
        }


        /*val lilm = FlexboxLayoutManager(this@MainActivityRecyclerViewHorizontalError).apply {
            flexWrap = FlexWrap.WRAP
            flexDirection = FlexDirection.ROW
            justifyContent = JustifyContent.FLEX_START
        }

        binding.btnf.setOnClickListener {
            binding.rv3.apply {
                layoutManager = null
                layoutManager =  lilm
                this.invalidate()
            }
        }*/

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
        (0..10).forEach { i -> data.add("$i ek444") }
        return data
    }
}