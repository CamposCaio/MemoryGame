package com.example.memorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createMemoryBoard()
    }

    private fun createMemoryBoard() {
        val numRows = 4
        val numColumns = 2

        rvBoard.adapter = MemoryBoardAdapter(this, numRows, numColumns)
        rvBoard.setHasFixedSize(true)
        rvBoard.layoutManager = GridLayoutManager(this, numColumns)
    }
}