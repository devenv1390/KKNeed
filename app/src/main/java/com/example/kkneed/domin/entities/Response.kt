package com.example.kkneed.domin.entities

sealed class Response<out T> {

    object Loading : Response<Nothing>()

    class Success<out T>(val data: T) : Response<T>()
    class Error(val message: String) : Response<Nothing>()

}