package com.example.kkneed.data

import androidx.camera.view.PreviewView
import com.example.kkneed.model.Scan

data class ScannerUiState(
    val previewView: PreviewView? = null,
    val scan: Scan? = null,
    val showBottomSheet: Boolean = false,
    val showCameraRequiredDialog: Boolean = false
)
