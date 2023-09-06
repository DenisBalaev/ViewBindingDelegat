package com.example.viewbindingdelegat.bottomsheet.new

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewbindingdelegat.R
import com.example.viewbindingdelegat.bottomsheet.*
import com.example.viewbindingdelegat.databinding.BottomDialogCommandCarScreenBinding
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class NewBottom(private val context: Context, private val layoutInflater: LayoutInflater)
{
    private var bottomSheetDialog: BottomSheetDialog = BottomSheetDialog(context)
    private var binding: BottomDialogCommandCarScreenBinding = BottomDialogCommandCarScreenBinding.inflate(layoutInflater)
    private var COLLAPSED_HEIGHT = 200
    private val list = mutableListOf<String>(
        "All","Cleaning","Cup&Lid","Products","Door","Sell","Ice","Other"
        ,"Cleaning","Cup&Lid","Products","Door","Sell","Ice","Other"
        ,"Cleaning","Cup&Lid","Products","Door","Sell","Ice","Other"
        ,"Cleaning","Cup&Lid","Products","Door","Sell","Ice","Other"
        ,"Cleaning","Cup&Lid","Products","Door","Sell","Ice","Other"
        ,"Cleaning","Cup&Lid","Products","Door","Sell","Ice","Other"
        ,"Cleaning","Cup&Lid","Products","Door","Sell","Ice","Other"
        ,"Cleaning","Cup&Lid","Products","Door","Sell","Ice","Other"
        ,"Cleaning","Cup&Lid","Products","Door","Sell","Ice","Other"
        ,"Cleaning","Cup&Lid","Products","Door","Sell","Ice","Other"
        ,"Cleaning","Cup&Lid","Products","Door","Sell","Ice","Other"
        ,"Cleaning","Cup&Lid","Products","Door","Sell","Ice","Other"
        ,"Cleaning","Cup&Lid","Products","Door","Sell","Ice","Other")
    private val listCommand = mutableListOf<ItemCommand>(
        ItemCommand(
            title = "Cup&Lid",
            listCommand = listOf(
                "Drop cups","Drop lids","Home","Progress","Drop cup release","Empty cup move forward","Remote drop cup","Gland test"
            )
        ),
        ItemCommand(
            title = "Cleaning&Tuning",
            listCommand = listOf(
                "Clean","Clean mixer","Clean brewer","Clean syrup pump","Pipe emptying","Syrop pipe exhaust","Syrup clean"
            )
        ),
        ItemCommand(
            title = "Products",
            listCommand = listOf(
                "Canister 1 test","Canister 2 test","Canister 4 test","Canister 5 test","Grinder 1 test","Grinder 2 test",
                "Syrup 2 test","Syrup 3 test","Water 2","Water 3","Fresh water"
            )
        ),
        ItemCommand(
            title = "Door",
            listCommand = listOf("Close/open door","Small door test")
        ),
        ItemCommand(
            title = "Sale",
            listCommand = listOf("Start prohibition","Close prohibition")
        ),
        ItemCommand(
            title = "Ice",
            listCommand = listOf(
                "Remote defrost","Remove the restriction of ice marker", "Remove the restriction of ice drink sales","Empty ice",
                "Ice test","Ice drink restriction","Ice stirring","Unlock the defrost of ice marker" ,"The return pipe temperature is too high to unlock"
            )
        ),
        ItemCommand(
            title = "Other",
            listCommand = listOf("Get goods information","Tap water")
        )
    )

    init {
        bottomSheetDialog.setContentView(binding.root)
        bottomSheetDialog.setCancelable(false)
    }

    fun show(){
        with(binding){

            rvFiltration.apply {
                layoutManager = FlexboxLayoutManager(context).apply {
                    flexWrap = FlexWrap.WRAP
                    flexDirection = FlexDirection.ROW
                    justifyContent = JustifyContent.FLEX_START
                }
                adapter = FiltrationBottomSheetAdapter(items = list){

                }
                addItemDecoration(
                    CustomItemDecorationFiltrationBottomSheet(
                        spaceTop = resources.getDimensionPixelSize(R.dimen.marginTop_recyclerView_Filtration_BottomSheet),
                        spaceRight = resources.getDimensionPixelSize(R.dimen.marginEnd_recyclerView_Filtration_BottomSheet)
                    )
                )
                setOnClickListener {
                    ViewCompat.setNestedScrollingEnabled(binding.rvFiltration, true)
                    ViewCompat.setNestedScrollingEnabled(binding.rvCommand, false)
                }
            }

            val bottomSheetGeneral = ActionCommandGeneralBottomSheetFragment(context,layoutInflater)
            rvCommand.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = CommandAdapter(items = listCommand){
                    bottomSheetGeneral.show(it)
                }
                setOnClickListener {
                    ViewCompat.setNestedScrollingEnabled(binding.rvFiltration, false)
                    ViewCompat.setNestedScrollingEnabled(binding.rvCommand, true)
                }
            }
        }
        bottomSheetDialog.show()
    }
}