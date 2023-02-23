package com.example.kkneed.model


import androidx.room.ColumnInfo
import androidx.room.TypeConverters
import com.example.kkneed.data.ProductConverters
import com.google.gson.annotations.SerializedName

@TypeConverters(ProductConverters::class)
data class NutrientLevels(

    @SerializedName("fat")
    @ColumnInfo(name = "nutrientLevels_fat") val fat: String,

    @SerializedName("salt")
    @ColumnInfo(name = "nutrientLevels_salt") val salt: String,

    @SerializedName("saturated-fat")
    @ColumnInfo(name = "nutrientLevels_saturatedFat") val saturatedFat: String,

    @SerializedName("sugars")
    @ColumnInfo(name = "nutrientLevels_sugars") val sugars: String
)