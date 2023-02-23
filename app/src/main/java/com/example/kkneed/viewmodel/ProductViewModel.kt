package com.example.kkneed.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kkneed.model.Product
import com.example.kkneed.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
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

    val nowProduct: LiveData<Product> by lazy {
        productRepo.getOneAllProduct()
    }
    val isLoading: LiveData<Boolean> get() = _isLoading
    var barcode: String = ""

    //食品数据库相关操作
    fun addProduct(barcode: String) {
        if (_isLoading.value == false)
            viewModelScope.launch(Dispatchers.IO) {
                _isLoading.postValue(true)
                productRepo.getNewProduct(barcode)
                _isLoading.postValue(false)
            }
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

