package com.example.kkneed.model


import com.google.gson.annotations.SerializedName

data class ProductX(
    @SerializedName("brands")
    val brands: String,
    @SerializedName("categories")
    val categories: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("_keywords")
    val keywords: List<String>,
    @SerializedName("nutrient_levels")
    val nutrientLevels: NutrientLevels,
    @SerializedName("nutriments")
    val nutriments: Nutriments,
    @SerializedName("nutriscore_grade")
    val nutriScoreGrade: String,
    @SerializedName("product_name")
    val productName: String,
    @SerializedName("traces_tags")
    val tracesTags: List<String>
)