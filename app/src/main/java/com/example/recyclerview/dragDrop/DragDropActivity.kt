package com.example.recyclerview.dragDrop

import android.graphics.Canvas
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_drag_drop.*
import java.util.*

class DragDropActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drag_drop)

        val listItem = mutableListOf<Item>()
        for (i in 1..20) {
            listItem.add(Item(i, "this is Item $i"))
        }
        val itemAdapter = ItemAdapter()
        itemAdapter.submitList(listItem)
        val itemDecorator = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val positionDragged = viewHolder.adapterPosition
                val positionTarget = target.adapterPosition
                Collections.swap(listItem, positionDragged, positionTarget)
                itemAdapter.notifyItemMoved(positionDragged, positionTarget)
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val itemDelete = listItem[viewHolder.adapterPosition]
                val nameItemDelete = itemDelete.nameItem
                val indexDelete = viewHolder.adapterPosition

                if (direction == ItemTouchHelper.LEFT) {
                    listItem.removeAt(indexDelete)
                    itemAdapter.notifyItemRemoved(indexDelete)
                    Snackbar.make(rootView, "$nameItemDelete is removed", Snackbar.LENGTH_LONG)
                        .run {
                            setAction("Undo") {
                                listItem.add(indexDelete, itemDelete)
                                itemAdapter.notifyItemInserted(indexDelete)
                            }
                            setActionTextColor(Color.YELLOW)
                            show()
                        }
                } else if (direction == ItemTouchHelper.RIGHT) {
                    listItem.removeAt(indexDelete)
                    itemAdapter.notifyItemRemoved(indexDelete)
                    Snackbar.make(rootView, "$nameItemDelete is approved", Snackbar.LENGTH_LONG)
                        .run {
                            setAction("Undo") {
                                listItem.add(indexDelete, itemDelete)
                                itemAdapter.notifyItemInserted(indexDelete)
                            }
                            setActionTextColor(Color.YELLOW)
                            show()
                        }
                }
            }

            override fun onChildDraw(
                c: Canvas,
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                dX: Float,
                dY: Float,
                actionState: Int,
                isCurrentlyActive: Boolean
            ) {
                RecyclerViewSwipeDecorator.Builder(
                    c,
                    recyclerView,
                    viewHolder,
                    dX,
                    dY,
                    actionState,
                    isCurrentlyActive
                )
                    .addSwipeLeftActionIcon(R.drawable.ic_baseline_delete_24)
                    .addSwipeRightActionIcon(R.drawable.ic_baseline_check_24)
                    .create()
                    .decorate()
                super.onChildDraw(
                    c,
                    recyclerView,
                    viewHolder,
                    dX,
                    dY,
                    actionState,
                    isCurrentlyActive
                )
            }
        })
        itemTouchHelper.attachToRecyclerView(recyclerViewDragDrop)
        recyclerViewDragDrop.run {
            adapter = itemAdapter
            addItemDecoration(itemDecorator)
        }
    }
}
