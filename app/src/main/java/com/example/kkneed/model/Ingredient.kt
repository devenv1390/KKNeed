package com.example.kkneed.model


import androidx.room.ColumnInfo
import androidx.room.TypeConverters
import com.example.kkneed.data.ProductConverters
import com.google.gson.annotations.SerializedName

@TypeConverters(ProductConverters::class)
data class Ingredient(

    @SerializedName("id")
    @ColumnInfo(name = "ingredient_name") val name: String?,

    @SerializedName("percent_estimate")
    @ColumnInfo(name = "ingredient_percentEstimate") val percentEstimate: Double?,

    @SerializedName("percent_max")
    @ColumnInfo(name = "ingredient_percentMax") val percentMax: Double?,

    @SerializedName("percent_min")
    @ColumnInfo(name = "ingredient_percentMin") val percentMin: Double?,

    @SerializedName("text")
    @ColumnInfo(name = "ingredient_text") val text: String?
)