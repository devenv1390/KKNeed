package com.example.kkneed.model

//@SuppressLint("UnsafeOptInUsageError")
//class BCAnalyzer(
//    private val onBarcodeDetected: (barcodes: List<Barcode>) -> Unit,
//): ImageAnalysis.Analyzer {
//    private var lastAnalyzedTimeStamp = 0L
//
//    override fun analyze(image: ImageProxy) {
//        val currentTimestamp = System.currentTimeMillis()
//        if (currentTimestamp - lastAnalyzedTimeStamp >= TimeUnit.SECONDS.toMillis(1)) {
//            image.image?.let { imageToAnalyze ->
//                val options = BarcodeScannerOptions.Builder()
//                    .setBarcodeFormats(Barcode.FORMAT_ALL_FORMATS)
//                    .build()
//                val barcodeScanner = BarcodeScanning.getClient(options)
//                val imageToProcess = InputImage.fromMediaImage(imageToAnalyze, image.imageInfo.rotationDegrees)
//
//                barcodeScanner.process(imageToProcess)
//                    .addOnSuccessListener { barcodes ->
//                        if (barcodes.isNotEmpty()) {
//                            onBarcodeDetected(barcodes)
//                        } else {
//                            Log.d("TAG", "analyze: No barcode Scanned")
//                        }
//                    }
//                    .addOnFailureListener { exception ->
//                        Log.d("TAG", "BarcodeAnalyser: Something went wrong $exception")
//                    }
//                    .addOnCompleteListener {
//                        image.close()
//                    }
//            }
//            lastAnalyzedTimeStamp = currentTimestamp
//        } else {
//            image.close()
//        }
//    }
//}