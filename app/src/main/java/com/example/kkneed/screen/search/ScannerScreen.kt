package com.example.kkneed.screen.search

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.kkneed.R
import com.example.kkneed.data.ScannerEvent
import com.example.kkneed.data.ScannerUiState
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.ui.ScanSheet
import com.example.kkneed.ui.ScanTopAppBar
import com.example.kkneed.ui.dialogs.CameraRequiredDialog
import com.example.kkneed.ui.theme.BaseDP
import com.example.kkneed.ui.theme.Black200
import com.example.kkneed.ui.theme.Black700
import com.example.kkneed.ui.theme.BottomSheetShape
import com.example.kkneed.viewmodel.ProductViewModel
import com.example.kkneed.viewmodel.ScannerViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BCScannerScreen(
    navController: NavController,
    viewModel: ScannerViewModel = hiltViewModel()
) {
    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val lifecycleOwner = LocalLifecycleOwner.current
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsState()

    val hapticFeedback = LocalHapticFeedback.current
    val activity = remember(context) {
        context as Activity
    }

    BackHandler(enabled = bottomSheetState.isVisible) {
        coroutineScope.launch {
            bottomSheetState.hide()
        }
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { granted ->
            if (granted) {
                viewModel.onEvent(ScannerEvent.CreatePreviewView(lifecycleOwner))
            } else {
                viewModel.onEvent(ScannerEvent.CameraRequiredDialogVisibility(show = true))
            }
        }
    )

    LaunchedEffect(key1 = bottomSheetState.currentValue) {
        if (uiState.previewView != null && !bottomSheetState.isVisible) {
            viewModel.onEvent(ScannerEvent.BottomSheetHidden)
        }
    }

    LaunchedEffect(key1 = lifecycleOwner) {
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            viewModel.onEvent(ScannerEvent.CreatePreviewView(lifecycleOwner))
        } else {
            permissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }

    SideEffect {
        if (uiState.showBottomSheet) {
            hapticFeedback.performHapticFeedback(HapticFeedbackType.LongPress)
            coroutineScope.launch { if (!bottomSheetState.isVisible) bottomSheetState.show() }
            viewModel.onEvent(ScannerEvent.BottomSheetShown)
        }
    }

    if (uiState.showCameraRequiredDialog) {
        CameraRequiredDialog(
            onContinueClicked = {
                viewModel.onEvent(ScannerEvent.CameraRequiredDialogVisibility(show = false))
                permissionLauncher.launch(Manifest.permission.CAMERA)
            },
            onExitClicked = {
                viewModel.onEvent(ScannerEvent.CameraRequiredDialogVisibility(show = false))
                activity.finish()
            }
        )
    }

    ScannerScreen(
        bottomSheetState = bottomSheetState,
        uiState = uiState,
        context = context,
        navController = navController,
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun ScannerScreen(
    bottomSheetState: ModalBottomSheetState,
    uiState: ScannerUiState,
    context: Context,
    navController: NavController,
    viewModel: ProductViewModel = hiltViewModel(),
) {
    val clipboardManager = LocalClipboardManager.current
    val uriHandler = LocalUriHandler.current

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetShape = BottomSheetShape,
        scrimColor = Color.Transparent,
        sheetContent = {
            uiState.scan?.let {
                ScanSheet(
                    scan = it,
                    onShareClicked = {
                        context.startActivity(
                            Intent.createChooser(
                                Intent().apply {
                                    action = Intent.ACTION_SEND
                                    putExtra(Intent.EXTRA_TEXT, it.displayValue)
                                    type = "text/plain"
                                },
                                context.getString(R.string.scan_share_value)
                            )
                        )
                    },
                    onInfoClicked = {
                        var flag = false
                        try {
                            val product = viewModel.queryProductCode(it.displayValue)
                            Log.d("RES", product.productName)
                        } catch (e: Exception) {
                            flag = true
                        }
                        if (flag) {
                            if (it.scanFormatId == R.string.scan_format_ean_13) {
                                navController.navigate(AllScreen.SCLoading.route + "/${it.displayValue}")
                            } else {
                                clipboardManager.setText(AnnotatedString(it.displayValue))
                                Toast.makeText(context, context.getText(R.string.scan_value_next_step), Toast.LENGTH_SHORT)
                                    .show()
                            }
                        } else {
                            navController.navigate(AllScreen.ScanResult.route + "/${it.displayValue}")
                        }
                    },
                    onWebClicked = {
                        uriHandler.openUri(it.displayValue)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = BaseDP)
                )
            } ?: Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Black200)
        ) {
            if (uiState.previewView != null) {
                AndroidView(
                    factory = { uiState.previewView },
                    modifier = Modifier.fillMaxSize()
                )
            }
            Surface(
                color = Black700.copy(alpha = 0.7f),
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .padding(BaseDP)
                    .align(Alignment.BottomCenter)
            ) {
                Text(
                    text = stringResource(id = R.string.scan_message),
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = BaseDP)
                )
            }
            ScanTopAppBar(56.dp, navController)
        }
    }
}