package com.example.kkneed.di

import com.example.kkneed.repository.ProductRepository
import com.example.kkneed.repository.ProductRepositoryImp
import com.example.kkneed.repository.ScanRepository
import com.example.kkneed.repository.ScanRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun productRepository(repo: ProductRepositoryImp): ProductRepository

    @Binds
    @Singleton
    abstract fun bindsScanRepository(
        scanRepositoryImpl: ScanRepositoryImpl
    ): ScanRepository
}