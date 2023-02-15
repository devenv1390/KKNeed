package com.example.kkneed.repository

import androidx.camera.view.PreviewView
import androidx.lifecycle.LifecycleOwner
import com.example.kkneed.model.Scan
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ScanRepositoryImpl @Inject constructor(
    private val scanLocal: ScanLocalDataSource
): ScanRepository {

    override fun getLatestScan(): Flow<Scan> = scanLocal.getLatestScan()

    override suspend fun getCameraPreview(lifecycleOwner: LifecycleOwner): PreviewView =
        scanLocal.getCameraPreview(lifecycleOwner)

    override suspend fun pauseScan() = scanLocal.pauseScan()

    override suspend fun resumeScan() = scanLocal.resumeScan()

}

interface ScanLocalDataSource {

    fun getLatestScan(): Flow<Scan>

    suspend fun getCameraPreview(lifecycleOwner: LifecycleOwner): PreviewView

    suspend fun pauseScan()

    suspend fun resumeScan()

}