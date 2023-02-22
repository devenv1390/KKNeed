package com.example.kkneed.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kkneed.model.Product
import com.example.kkneed.model.ProductDao

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class DbDataSource : RoomDatabase() {

    abstract fun productDao(): ProductDao
}