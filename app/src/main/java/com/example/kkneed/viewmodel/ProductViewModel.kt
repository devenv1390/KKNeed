package com.example.kkneed.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kkneed.model.Product
import com.example.kkneed.model.hasProduct
import com.example.kkneed.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepo: ProductRepository
) : ViewModel() {
    //livedata相关
    private val _isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }

    val products: LiveData<List<Product>> by lazy {
        productRepo.getAllProduct()
    }

    val isLoading: LiveData<Boolean> get() = _isLoading
    var barcode: String = ""
    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        Log.d(TAG, "CoroutineExceptionHandler exception : ${exception.message}" )
    }

    //食品数据库相关操作
    fun addProduct(barcode: String) {
        if (_isLoading.value == false)
            viewModelScope.launch(exceptionHandler) {
                _isLoading.postValue(true)
                productRepo.getNewProduct(barcode)
                _isLoading.postValue(false)
            }
    }

    suspend fun hasProduct(barcode: String):hasProduct{
        var tempProduct = hasProduct(0,"product not found")
        viewModelScope.launch(exceptionHandler){
            _isLoading.postValue(true)
            tempProduct = productRepo.hasProduct(barcode)
            _isLoading.postValue(false)
        }
        delay(10000)
        return tempProduct
    }

    fun queryProductCode(barcode: String): Product {
        return productRepo.queryProductCode(barcode)
    }

    fun queryProductScore(score: String): List<Product> {
        return productRepo.queryProductScore(score)
    }

    fun deleteProduct(toDelete: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            productRepo.deleteProduct(toDelete)
        }
    }
}

