package com.example.kkneed.datasource

import com.example.kkneed.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface OFFDataSource {
    @GET("api/v2/product/{barcode}/?fields=code,product_name,image_url")
    suspend fun getProductCode(@Path("barcode") barcode:String): ApiResponse
    @GET("api/v2/product/{barcode}/?fields=product_name")
    suspend fun getProductName():ApiResponse
    @GET("api/v2/product/{barcode}/?fields=image_url")
    suspend fun getProductPic():ApiResponse
}