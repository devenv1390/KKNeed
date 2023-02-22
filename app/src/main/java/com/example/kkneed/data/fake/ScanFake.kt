package com.example.kkneed.data.fake

import com.example.kkneed.R
import com.example.kkneed.model.Product
import com.example.kkneed.model.Scan
import com.example.kkneed.model.ScanType

val fakeScan = Scan(
    displayValue = "123",
    scanFormatId = R.string.scan_format_qr_code,
    scanType = ScanType.Text
)

val fakeProduct = Product(
    "code",
    "name",
    "https://images.openfoodfacts.net/images/products/301/762/401/0701/front_en.54.100.jpg",
    "brands"
)