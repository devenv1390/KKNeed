package com.example.kkneed.datasource

import com.example.kkneed.model.ApiResponse
import com.example.kkneed.model.hasProduct
import retrofit2.http.GET
import retrofit2.http.Path

interface OFFDataSource {
    @GET("api/v2/product/{barcode}/?fields=code,product_name,image_url,brands,nutriments,nutrient_levels,nutriscore_grade,traces_tags,_keywords,categories,ingredients")
    suspend fun getProduct(@Path("barcode") barcode:String):ApiResponse

    @GET("api/v2/product/{barcode}/?fields=code,product_name,image_url,brands,nutriments,nutrient_levels,nutriscore_grade,traces_tags,_keywords,categories,ingredients")
    suspend fun hasProduct(@Path("barcode") barcode:String):hasProduct
}