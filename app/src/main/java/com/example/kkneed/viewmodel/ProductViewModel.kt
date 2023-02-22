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
):ViewModel() {

    private val _isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }

    val products: LiveData<List<Product>> by lazy {
        productRepo.getAllProduct()
    }

    val product:LiveData<Product> by lazy {
        productRepo.getOneAllProduct()
    }

    val result = products

    val isLoading: LiveData<Boolean> get() = _isLoading

    fun addProduct(barcode:String): Product {
        var product = Product("code", "name", "https://images.openfoodfacts.net/images/products/301/762/401/0701/front_en.54.100.jpg", "brands")
        if (_isLoading.value==false)
            viewModelScope.launch(Dispatchers.IO) {
                _isLoading.postValue(true)
                product = productRepo.getNewProduct(barcode)
                _isLoading.postValue(false)
            }
        return product
    }

    fun deleteProduct(toDelete: Product){
        viewModelScope.launch(Dispatchers.IO) {
            productRepo.deleteProduct(toDelete)
        }
    }
}

