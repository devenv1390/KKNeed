package com.example.kkneed

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kkneed.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepositoryImp: ProductRepository
):ViewModel() {

    fun getProduct(barcode:String){
        viewModelScope.launch(Dispatchers.IO){
            val product = productRepositoryImp.getNewProduct(barcode)
            Log.d("productViewModel",product.toString())
        }
    }
}