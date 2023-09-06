package com.example.viewbindingdelegat.bottomsheet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbindingdelegat.R
import com.example.viewbindingdelegat.databinding.ItemBottomSheetCommandListBinding

class CommandAdapter(
    private val items:List<ItemCommand>,
    private val listener:(String)-> Unit
): RecyclerView.Adapter<CommandAdapter.ViewHolder>(){

    class ViewHolder(private val binding:ItemBottomSheetCommandListBinding): RecyclerView.ViewHolder(binding.root){

        init {
            binding.rvListCommand.apply {
                layoutManager = LinearLayoutManager(context)
                addItemDecoration(CustomItemDecorationCommandBottomSheet(resources.getDimensionPixelSize(
                    R.dimen.marginTop_recyclerView_Command_BottomSheet)))
            }
        }

        fun bindView(item:ItemCommand, listener: (String) -> Unit)= with(binding){
            title.text = item.title
            rvListCommand.adapter = ChildCommandAdapter(items = item.listCommand){
                listener(it)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBottomSheetCommandListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(items[position],listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}