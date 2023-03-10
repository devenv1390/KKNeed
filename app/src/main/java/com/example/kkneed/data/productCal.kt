package com.example.kkneed.data

import androidx.compose.runtime.Composable
import com.example.kkneed.R
import com.example.kkneed.data.fake.fakeLevel
import com.example.kkneed.model.Product
import com.example.kkneed.ui.theme.*

@Composable
fun findLevel(score: String): LevelItem {
    val matchLevel: LevelItem = fakeLevel
    when (score) {
        "a" -> {
            matchLevel.gradeImage = R.drawable.alevel
            matchLevel.matchText = "健康匹配度高"
            matchLevel.matchColor = LevelA
        }

        "b" -> {
            matchLevel.gradeImage = R.drawable.blevel
            matchLevel.matchText = "健康匹配度较高"
            matchLevel.matchColor = LevelB
        }

        "c" -> {
            matchLevel.gradeImage = R.drawable.clevel
            matchLevel.matchText = "健康匹配度一般"
            matchLevel.matchColor = LevelC
        }

        "d" -> {
            matchLevel.gradeImage = R.drawable.dlevel
            matchLevel.matchText = "健康匹配度较低"
            matchLevel.matchColor = LevelD
        }

        "e" -> {
            matchLevel.gradeImage = R.drawable.elevel
            matchLevel.matchText = "健康匹配度低"
            matchLevel.matchColor = LevelE
        }
    }
    return matchLevel
}

@Composable
fun productCalculator(productLeft: Double, productRight: Double): ProductValue {
    val total = productLeft + productRight
    val left = productLeft / total
    val right = productRight / total
    return ProductValue(left, right)
}

@Composable
fun ingredientAnalyser(item: DetailItemData, mutableList: MutableList<DetailItemData>): MutableList<DetailItemData> {
    mutableList.add(0, item)
    return mutableList
}

@Composable
fun ingredientAnalyserSugar(product: Product, check: Int): Int {
    var state = check
    for (item in product.ingredients) {
        if (item.text.equals("糖")) {
            state = R.drawable.ture
        }
    }
    return state
}

@Composable
fun ingredientAnalyserSaFat(product: Product, check: Int): Int {
    var state = check
    if (product.nutriments.saturatedFat100g != null) {
        if (product.nutriments.saturatedFat100g > 0) {
            state = R.drawable.ture
        }
    }
    return state
}

@Composable
fun randomNumFloat(): Float {
    var result = (0 until 10).random().toFloat()
    result /= 10
    if (result <= 0f || result == 1f) {
        result = randomNumFloat()
    }
    return result
}