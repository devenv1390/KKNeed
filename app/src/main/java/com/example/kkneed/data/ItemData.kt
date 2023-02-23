package com.example.kkneed.data

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

data class GuideScreenItemData (//引导页的item数据类
    val image: Int,
    val title: String,
    val content: String,
)
data class ButtonItemData(
    val icon: Painter,
    val title: String,
    val route: String,
)
data class DetailItemData(
    var title: String,
    var value: String,
    var color: Color,
)
data class LevelItem(
    var gradeImage:Int,
    var matchText:String,
    var matchColor: Color,
)
data class ProductValue(
    val left:Double,
    val right:Double,
)