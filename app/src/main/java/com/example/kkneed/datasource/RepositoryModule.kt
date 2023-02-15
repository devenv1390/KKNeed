package com.example.kkneed.datasource

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

    @Binds
    @Singleton
    abstract fun bindsScanRepository(
        scanRepositoryImpl: ScanRepositoryImpl
    ): ScanRepository

}