package com.example.kkneed.model

import androidx.compose.ui.graphics.vector.ImageVector

data class GuideScreenItemData (//引导页的item数据类
    val image: Int,
    val title: String,
    val content: String,
)
data class ButtomItemData(
    val image: ImageVector,
    val title: String,
    val route: String
)