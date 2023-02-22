package com.example.kkneed.model


import androidx.room.ColumnInfo
import androidx.room.TypeConverters
import com.example.kkneed.data.ProductConverters
import com.google.gson.annotations.SerializedName

@TypeConverters(ProductConverters::class)
data class Ingredient(
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "ingredient_id")
//    var ingredientId: Int = 0,

    @SerializedName("id")
    @ColumnInfo(name = "ingredient_name") val name: String,

    @SerializedName("percent_estimate")
    @ColumnInfo(name = "ingredient_percentEstimate") val percentEstimate: Double,

    @SerializedName("percent_max")
    @ColumnInfo(name = "ingredient_percentMax") val percentMax: Double,

    @SerializedName("percent_min")
    @ColumnInfo(name = "ingredient_percentMin") val percentMin: Double,

    @SerializedName("text")
    @ColumnInfo(name = "ingredient_text") val text: String
)