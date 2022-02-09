package com.mariobr.terceiraprova.adapters


import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class NovoReciclerViewClickListener(val view: RecyclerView, val listener:OnItemClickListener) : RecyclerView.OnItemTouchListener  {

    var myGestureDetector: GestureDetector = GestureDetector(view.context, object : GestureDetector.SimpleOnGestureListener() {
        override fun onSingleTapUp(motionEvent: MotionEvent): Boolean {
            super.onSingleTapUp(motionEvent)
            val childView = view.findChildViewUnder(motionEvent.x, motionEvent.y)
            if (childView != null) {
                listener.onItemClick(childView, view.getChildAdapterPosition(childView))
            }
            return true
        }

        override fun onLongPress(motionEvent: MotionEvent) {
            super.onLongPress(motionEvent)
            val childView = view.findChildViewUnder(motionEvent.x, motionEvent.y)
            if (childView != null) {
                listener.onItemLongClick(
                    childView,
                    view.getChildAdapterPosition(childView)
                )
            }
        }
    })

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
        fun onItemLongClick(view: View, position: Int)
    }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        myGestureDetector.onTouchEvent(e);
        return false
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
    }
}