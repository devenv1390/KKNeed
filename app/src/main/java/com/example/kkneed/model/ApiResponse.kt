package com.example.kkneed.model

import com.google.gson.annotations.SerializedName

data class ApiResponse (
//    val product:List<Products> = emptyList()
    @SerializedName("code")
    val code: String,
    @SerializedName("product")
    val product: ProductX,
    @SerializedName("status")
    val status: Int,
    @SerializedName("status_verbose")
    val statusVerbose: String
)