package com.example.memorygame

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.min

class MemoryBoardAdapter(private val context: Context, private val numRows: Int, private val numColumns: Int) :
    RecyclerView.Adapter<MemoryBoardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cardMaxWidth : Int = parent.width / numColumns
        val cardMaxHeight : Int = parent.height / numRows
        val cardSideLength = min(cardMaxWidth, cardMaxHeight)
        val view : View = LayoutInflater.from(context).inflate(R.layout.memory_card, parent, false)
        val layoutParams : ViewGroup.LayoutParams =
            view.findViewById<CardView>(R.id.containerCardView).layoutParams as ViewGroup.LayoutParams
        layoutParams.width = cardSideLength
        layoutParams.height = cardSideLength
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = numRows * numColumns

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageButton = itemView.findViewById<ImageButton>(R.id.imageButton)
        fun bind(position: Int) {
            imageButton.setOnClickListener {
                Toast.makeText(context, "clicked on position $position", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
