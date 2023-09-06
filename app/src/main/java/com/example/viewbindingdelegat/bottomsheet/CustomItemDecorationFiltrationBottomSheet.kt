package com.example.viewbindingdelegat.bottomsheet

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class CustomItemDecorationFiltrationBottomSheet (private val spaceRight: Int,private val spaceTop :Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildLayoutPosition(view)
        val isLastItem = position == state.itemCount - 1

        if (!isLastItem) {
            outRect.right = spaceRight
        } else {
            outRect.right = 0
        }

        outRect.top = spaceTop
    }
}