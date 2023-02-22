package com.example.kkneed.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Entity(tableName = "product")
data class Product(
    @ColumnInfo(name = "code") val code: String,
    @ColumnInfo(name = "name") val productName: String,
    @ColumnInfo(name = "image") val imageUrl: String,
    @ColumnInfo(name = "brands") val brands: String,
    @ColumnInfo(name = "nutriscore")val nutriScoreGrade:String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)
@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(product: Product)

    @Query("SELECT * FROM product ORDER BY id DESC")
    fun getAll(): LiveData<List<Product>>

    @Query("SELECT * FROM product ORDER BY id DESC LIMIT 1")
    fun getOne(): LiveData<Product>

    @Query("SELECT * FROM product WHERE code=:code")
    fun queryProductCode(code: String): Product

    @Delete
    fun delete(product: Product)
}