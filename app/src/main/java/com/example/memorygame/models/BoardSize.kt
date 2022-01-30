package com.example.memorygame.models

enum class BoardSize(val numRows : Int, val numColumns : Int) {
    SMALL(4, 2),
    MEDIUM(6, 3),
    LARGE(6, 4);

    fun getNumPieces() : Int {
        return numRows * numColumns
    }

    fun getNumPairs() : Int {
        return numRows * numColumns / 2
    }

}
