package com.example.kkneed.model

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.kkneed.data.ProductConverters
import com.example.kkneed.data.fake.fakeNutrientLevels
import com.example.kkneed.data.fake.fakeNutriments

@TypeConverters(ProductConverters::class)
@Entity(tableName = "product")
data class Product(
    @ColumnInfo(name = "code") val code: String,
    @ColumnInfo(name = "name") val productName: String,
    @ColumnInfo(name = "image") val imageUrl: String,
    @ColumnInfo(name = "brands") val brands: String,
    @ColumnInfo(name = "score") val scoreGrade: String,
    @ColumnInfo(name = "categories") val categories: String,
    val keywords: List<String>,
    val tracesTags: List<String>,
    val ingredients: List<Ingredient>,
    val nutrientLevels: NutrientLevels,
    val nutriments: Nutriments,

    @PrimaryKey(autoGenerate = true) var id: Int = 0,
) {
    constructor() : this(
        "",
        "",
        "",
        "",
        "",
        "",
        emptyList(),
        emptyList(),
        emptyList(),
        fakeNutrientLevels,
        fakeNutriments
    )
}

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(product: Product)

    @Query("SELECT * FROM product ORDER BY id DESC")
    fun getAll(): LiveData<List<Product>>

    @Query("SELECT * FROM product ORDER BY id DESC LIMIT 1")
    fun getLastOne(): LiveData<Product>

    @Query("SELECT * FROM product WHERE code=:code")
    fun queryProductCode(code: String): Product

    @Query("SELECT * FROM product WHERE score=:score")
    fun queryProductScore(score: String): Product

    @Delete
    fun delete(product: Product)
}