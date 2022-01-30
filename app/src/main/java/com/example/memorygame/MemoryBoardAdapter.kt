package com.example.memorygame

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.memorygame.models.BoardSize
import kotlin.math.min

class MemoryBoardAdapter(
    private val context: Context,
    private val boardSize: BoardSize,
    private val cardImages: List<Int>
) :
    RecyclerView.Adapter<MemoryBoardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cardSideLength = calculateCardSideLength(parent)
        val view : View = LayoutInflater.from(context).inflate(R.layout.memory_card, parent, false)
        val layoutParams : ViewGroup.LayoutParams =
            view.findViewById<CardView>(R.id.containerCardView).layoutParams as ViewGroup.LayoutParams
        layoutParams.width = cardSideLength
        layoutParams.height = cardSideLength
        return ViewHolder(view)
    }

    private fun calculateCardSideLength(parent: ViewGroup): Int {
        val cardMaxWidth : Int = parent.width / boardSize.numColumns
        val cardMaxHeight : Int = parent.height / boardSize.numRows
        return min(cardMaxWidth, cardMaxHeight)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = boardSize.getNumPieces()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageButton = itemView.findViewById<ImageButton>(R.id.imageButton)
        fun bind(position: Int) {
            imageButton.setImageResource(cardImages[position])
            imageButton.setOnClickListener {
                Toast.makeText(context, "clicked on position $position", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
