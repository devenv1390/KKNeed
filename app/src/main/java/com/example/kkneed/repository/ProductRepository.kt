package com.example.kkneed.repository

import androidx.lifecycle.LiveData
import com.example.kkneed.datasource.OFFDataSource
import com.example.kkneed.model.Product
import com.example.kkneed.model.ProductDao
import com.example.kkneed.model.hasProduct
import javax.inject.Inject

interface ProductRepository {//对外的操作接口
    //获取商品信息，并存入本地数据库
    suspend fun getNewProduct(barcode: String): Product
    //检查是否存在该商品
    suspend fun hasProduct(barcode: String):hasProduct
    //从本地数据库删除商品
    suspend fun deleteProduct(toDelete: Product)
    //获取本地数据库的所有商品
    fun getAllProduct(): LiveData<List<Product>>
    //获取本地数据库最新的一个商品
    fun getOneProduct(): LiveData<Product>
    //按barcode查询本地数据库
    fun queryProductCode(barcode: String): Product
    //按营养分数评级查询本地数据库
    fun queryProductScore(score: String): List<Product>
}

class ProductRepositoryImp @Inject constructor(
    private val dataSource: OFFDataSource,
    private val productDao: ProductDao
) : ProductRepository {//内部操作类
    override suspend fun getNewProduct(barcode: String): Product {
        val code = dataSource.getProduct(barcode).code
        val name = dataSource.getProduct(barcode).product.productName
        val picture = dataSource.getProduct(barcode).product.imageUrl
        val brands = dataSource.getProduct(barcode).product.brands
        val score = dataSource.getProduct(barcode).product.nutriScoreGrade
        val ingredient = dataSource.getProduct(barcode).product.ingredients
        val keywords = dataSource.getProduct(barcode).product.keywords
        val nutrientLevels = dataSource.getProduct(barcode).product.nutrientLevels
        val nutriments = dataSource.getProduct(barcode).product.nutriments
        val tracesTags = dataSource.getProduct(barcode).product.tracesTags
        val categories = dataSource.getProduct(barcode).product.categories
        val product = Product(
            code = code, productName = name, imageUrl = picture, brands = brands, scoreGrade = score,
            ingredients = ingredient, keywords = keywords, nutrientLevels = nutrientLevels,
            nutriments = nutriments, tracesTags = tracesTags, categories = categories
        )
        productDao.insert(product)
        return product
    }

    override suspend fun hasProduct(barcode: String): hasProduct {
        val status = dataSource.hasProduct(barcode).status
        val statusVerbose = dataSource.hasProduct(barcode).statusVerbose
        val productStatus = hasProduct(status, statusVerbose)
        return productStatus
    }

    override suspend fun deleteProduct(toDelete: Product) = productDao.delete(toDelete)
    override fun getAllProduct(): LiveData<List<Product>> = productDao.getAll()
    override fun getOneProduct(): LiveData<Product> = productDao.getLastOne()
    override fun queryProductCode(barcode: String): Product {
        return productDao.queryProductCode(barcode)
    }
    override fun queryProductScore(score: String): List<Product> {
        return productDao.queryProductScore(score)
    }
}