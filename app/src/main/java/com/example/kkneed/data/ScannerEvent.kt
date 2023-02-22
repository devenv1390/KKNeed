package com.example.kkneed.data

import androidx.lifecycle.LifecycleOwner

sealed class ScannerEvent {
    data class CreatePreviewView(val lifecycleOwner: LifecycleOwner): ScannerEvent()
    object BottomSheetShown: ScannerEvent()
    object BottomSheetHidden: ScannerEvent()
    data class CameraRequiredDialogVisibility(val show: Boolean): ScannerEvent()
}
