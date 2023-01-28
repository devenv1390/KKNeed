package com.example.kkneed

import androidx.compose.ui.graphics.vector.ImageVector

data class ItemData (
    val image: Int,
    val title: String,
    val content: String,
)
data class Item(
    val index: Int,
    val name: String,
    val icon: ImageVector,
)