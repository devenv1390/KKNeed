package com.example.kkneed.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kkneed.data.ScannerEvent
import com.example.kkneed.data.ScannerUiState
import com.example.kkneed.repository.ScanRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScannerViewModel @Inject constructor(
    private val scanRepository: ScanRepository
): ViewModel() {

    private val vmState = MutableStateFlow(ScannerUiState())

    val uiState = vmState.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        vmState.value
    )

    init {
        viewModelScope.launch {
            scanRepository.getLatestScan().collectLatest { scan ->
                if (scan.displayValue.isNotBlank()) {
                    scanRepository.pauseScan()
                    vmState.update { it.copy( scan = scan, showBottomSheet = true ) }
                }
            }
        }
    }

    fun onEvent(event: ScannerEvent) {
        when(event) {
            is ScannerEvent.CreatePreviewView -> {
                viewModelScope.launch {
                    val previewView = scanRepository.getCameraPreview(event.lifecycleOwner)
                    vmState.update { it.copy( previewView = previewView ) }
                }
            }
            ScannerEvent.BottomSheetShown -> {
                viewModelScope.launch { scanRepository.pauseScan() }
                vmState.update { it.copy( showBottomSheet = false ) }
            }
            ScannerEvent.BottomSheetHidden -> {
                viewModelScope.launch { scanRepository.resumeScan() }
            }
            is ScannerEvent.CameraRequiredDialogVisibility -> {
                vmState.update { it.copy( showCameraRequiredDialog = event.show ) }
            }
        }
    }
}