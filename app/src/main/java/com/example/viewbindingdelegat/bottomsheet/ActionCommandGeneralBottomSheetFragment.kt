package com.example.viewbindingdelegat.bottomsheet

import android.content.Context
import android.view.LayoutInflater
import android.widget.Toast
import com.example.viewbindingdelegat.databinding.BottomDialogActionsCommandsBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class ActionCommandGeneralBottomSheetFragment(
    private val context: Context,
    private val layoutInflater: LayoutInflater
) {

    private var bottomSheetDialog: BottomSheetDialog = BottomSheetDialog(context)
    private var binding: BottomDialogActionsCommandsBinding = BottomDialogActionsCommandsBinding.inflate(layoutInflater)

    init {
        binding.ivClose.setOnClickListener {
            bottomSheetDialog.dismiss()
        }

        bottomSheetDialog.setContentView(binding.root)
        bottomSheetDialog.setCancelable(false)
    }

    fun show(message:String){
        binding.title.text = message
        binding.btnAction.apply {
            text = "Применить команду"
            setOnClickListener {
                Toast.makeText(context,"Команда применена",Toast.LENGTH_LONG).show()
                bottomSheetDialog.dismiss()
            }
        }
        bottomSheetDialog.show()
    }

}