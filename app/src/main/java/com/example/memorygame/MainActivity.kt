package com.example.memorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.memorygame.models.BoardSize
import com.example.memorygame.utils.DEFAULT_IMAGES
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createMemoryBoard()
    }

    private fun createMemoryBoard() {

        val boardSize = BoardSize.LARGE
        val chosenImages = DEFAULT_IMAGES.shuffled().take(boardSize.getNumPairs())
        val randomizedImages = (chosenImages + chosenImages).shuffled()

        rvBoard.adapter = MemoryBoardAdapter(this, boardSize, randomizedImages)
        rvBoard.setHasFixedSize(true)
        rvBoard.layoutManager = GridLayoutManager(this, boardSize.numColumns)
    }
}