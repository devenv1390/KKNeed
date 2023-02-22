package com.example.kkneed.datasource

import com.example.kkneed.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface OFFDataSource {
    @GET("api/v2/product/{barcode}/?fields=code,product_name,image_url,brands")
    suspend fun getProduct(@Path("barcode") barcode:String):ApiResponse

    @GET("api/v2/product/{barcode}/?fields=code,product_name,image_url,brands")
    fun getScanProduct(@Path("barcode") barcode:String): Call<ApiResponse>
}