package com.example.kkneed.screen.search

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
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
import com.example.kkneed.navigation.ScannerDirection
import com.example.kkneed.ui.ScanSheet
import com.example.kkneed.ui.ScanTopAppBar
import com.example.kkneed.ui.dialogs.CameraRequiredDialog
import com.example.kkneed.ui.theme.BaseDP
import com.example.kkneed.ui.theme.Black200
import com.example.kkneed.ui.theme.Black700
import com.example.kkneed.ui.theme.BottomSheetShape
import com.example.kkneed.viewmodel.ProductViewModel
import com.example.kkneed.viewmodel.ScannerUiState
import com.example.kkneed.viewmodel.ScannerViewModel
import kotlinx.coroutines.launch

//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@OptIn(ExperimentalPermissionsApi::class, ExperimentalMaterialApi::class)
//@Composable
//fun BCScannerScreen(navController: NavController) {
//    val state = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
//    val scope = rememberCoroutineScope()
//    ModalBottomSheetLayout(
//        sheetState = state,
//        sheetShape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
//        sheetContent = {
//            ScanBottomSheet(state, scope)
//        }
//    ){
//        Scaffold(
//            backgroundColor = Color.Transparent,
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//            )
//            {
////            CameraPreview(navController)
//                Box(
//                    modifier = Modifier.fillMaxWidth(),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Image(
//                        painter = painterResource(R.drawable.scan),
//                        contentDescription = "",
//                        modifier = Modifier
//                            .size(379.dp, 182.dp),
//                        contentScale = ContentScale.Fit
//                    )
//                    androidx.compose.material3.IconButton(
//                        onClick = { /*TODO*/ },
//                        modifier = Modifier
//                            .align(Alignment.BottomEnd)
//                            .padding(bottom = 16.dp, end = 20.dp)
//                    ) {
//                        androidx.compose.material3.Icon(
//                            painter = painterResource(id = R.drawable.flashon),
//                            null,
//                            modifier = Modifier.size(24.dp),
//                            tint = Color.White
//                        )
//                    }
//                }
//                Spacer(modifier = Modifier.height(100.dp))
//                Box(modifier = Modifier.fillMaxWidth()) {
//                    Column(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        verticalArrangement = Arrangement.spacedBy(20.dp)
//                    ) {
//                        Image(
//                            painter = painterResource(R.drawable.dog),
//                            contentDescription = "",
//                            modifier = Modifier
//                                .size(56.dp),
//                            contentScale = ContentScale.Fit
//                        )
//                        Text(
//                            "欢迎使用康康Need",
//                            style = androidx.compose.material3.MaterialTheme.typography.headlineMedium,
//                            color = androidx.compose.material3.MaterialTheme.colorScheme.onPrimary
//                        )
//                        Text(
//                            "搜索产品名或扫描产品包装的条形码",
//                            style = androidx.compose.material3.MaterialTheme.typography.titleSmall,
//                            color = androidx.compose.material3.MaterialTheme.colorScheme.onPrimary.copy(0.8f)
//                        )
//                    }
//                }
//            }
//        }
//    }
//
//}

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
                    onCopyClicked = {
                        clipboardManager.setText(AnnotatedString(it.displayValue))
                        Toast.makeText(context, context.getText(R.string.scan_value_copied), Toast.LENGTH_SHORT).show()
                        viewModel.addProduct(it.displayValue)
                        navController.navigate(ScannerDirection.actionScanToResult(it.displayValue, "BC"))
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