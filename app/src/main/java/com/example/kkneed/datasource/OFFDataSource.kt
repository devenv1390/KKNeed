package com.example.kkneed.datasource

import com.example.kkneed.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface OFFDataSource {
    @GET("api/v2/product/{barcode}/?fields=code,product_name,image_url,brands,nutriments,nutrient_levels,nutriscore_grade,traces_tags,_keywords,categories")
    suspend fun getProduct(@Path("barcode") barcode:String):ApiResponse
}