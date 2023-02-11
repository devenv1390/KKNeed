package com.example.kkneed.screen.search

import android.Manifest
import android.annotation.SuppressLint
import android.util.Log
import android.view.ViewGroup
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.kkneed.R
import com.example.kkneed.model.BCAnalyzer
import com.example.kkneed.navigation.ScannerDirection
import com.example.kkneed.ui.BackButton
import com.example.kkneed.ui.ScanTopAppBar
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.google.common.util.concurrent.ListenableFuture
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun BCScannerScreen(navController: NavController) {
    Scaffold(
        backgroundColor = Color.Transparent,
        topBar = { ScanTopAppBar(64.dp, navController) }
    ){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp))
        {
            Spacer(modifier = Modifier.height(10.dp))

            val cameraPermissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)

            Row {
                BackButton(navController)
                Button(
                    onClick = {
                        cameraPermissionState.launchPermissionRequest()
                    }
                ) {
                    Text(text = "Camera Permission")
                }
            }

            //原来的代码处
            Spacer(modifier = Modifier.height(10.dp))

            CameraPreview(navController)
            Box(modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center){
                Image(
                    painter = painterResource(R.drawable.scan),
                    contentDescription = "",
                    modifier = Modifier
                        .size(379.dp,182.dp),
                    contentScale = ContentScale.Fit
                )
                androidx.compose.material3.IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(bottom = 16.dp, end = 20.dp)
                ) {
                    androidx.compose.material3.Icon(
                        painter = painterResource(id = R.drawable.flashon),
                        null,
                        modifier = Modifier.size(24.dp),
                        tint = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.height(100.dp))
            Box(modifier = Modifier.fillMaxWidth()){
                Column(modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(20.dp)) {
                    Image(
                        painter = painterResource(R.drawable.dog),
                        contentDescription = "",
                        modifier = Modifier
                            .size(56.dp),
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        "欢迎使用康康Need",
                        style = androidx.compose.material3.MaterialTheme.typography.headlineMedium,
                        color = androidx.compose.material3.MaterialTheme.colorScheme.onPrimary
                    )
                    Text(
                        "搜索产品名或扫描产品包装的条形码",
                        style = androidx.compose.material3.MaterialTheme.typography.titleSmall,
                        color = androidx.compose.material3.MaterialTheme.colorScheme.onPrimary.copy(0.8f)
                    )
                }
            }
        }
    }
}


@SuppressLint("RestrictedApi")
@Composable
fun CameraPreview(navController: NavController) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    var preview by remember { mutableStateOf<Preview?>(null) }
    val barCodeVal = remember { mutableStateOf("") }

    AndroidView(
        factory = { AndroidViewContext ->
            PreviewView(AndroidViewContext).apply {
                this.scaleType = PreviewView.ScaleType.FILL_CENTER
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                )
                implementationMode = PreviewView.ImplementationMode.COMPATIBLE
            }
        },

        modifier = Modifier
            .fillMaxSize()
    ) { previewView ->
        val cameraSelector: CameraSelector = CameraSelector.Builder()
            .requireLensFacing(CameraSelector.LENS_FACING_BACK)
            .build()
        val cameraExecutor: ExecutorService = Executors.newSingleThreadExecutor()
        val cameraProviderFuture: ListenableFuture<ProcessCameraProvider> =
            ProcessCameraProvider.getInstance(context)

        cameraProviderFuture.addListener({
            preview = Preview.Builder().build().also {
                it.setSurfaceProvider(previewView.surfaceProvider)
            }
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()
            val barcodeAnalyser = BCAnalyzer { barcodes ->
                barcodes.forEach { barcode ->
                    barcode.rawValue?.let { barcodeValue ->
                        barCodeVal.value = barcodeValue
                        Toast.makeText(context, barcodeValue, Toast.LENGTH_SHORT).show()
                        navController.navigate(ScannerDirection.actionMaintoNew(barCodeVal.value,"BC"))
                        cameraProvider.shutdown()
                    }
                }
            }
            val imageAnalysis: ImageAnalysis = ImageAnalysis.Builder()
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                .build()
                .also {
                    it.setAnalyzer(cameraExecutor, barcodeAnalyser)
                }

            try {
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(
                    lifecycleOwner,
                    cameraSelector,
                    preview,
                    imageAnalysis
                )
            } catch (e: Exception) {
                Log.d("TAG", "CameraPreview: ${e.localizedMessage}")
            }
        }, ContextCompat.getMainExecutor(context))
    }
}