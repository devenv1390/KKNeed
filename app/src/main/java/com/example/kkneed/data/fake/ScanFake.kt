package com.example.kkneed.data.fake

import com.example.kkneed.R
import com.example.kkneed.model.Scan
import com.example.kkneed.model.ScanType

val fakeScan = Scan(
    displayValue = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.",
    scanFormatId = R.string.scan_format_qr_code,
    scanType = ScanType.Text
)