package com.example.kkneed.di

import com.example.kkneed.data.ScanLDS
import com.example.kkneed.repository.ScanLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ScanDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindsScanLocalDataSource(
        scanLDS: ScanLDS
    ): ScanLocalDataSource

}