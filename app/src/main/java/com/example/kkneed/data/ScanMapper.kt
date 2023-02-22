package com.example.kkneed.data

import com.example.kkneed.R
import com.example.kkneed.model.Scan
import com.example.kkneed.model.ScanType
import com.google.mlkit.vision.barcode.common.Barcode

fun Barcode.toScan(): Scan {
    return Scan(
        displayValue = displayValue ?: "",
        scanFormatId = when(format) {
            Barcode.FORMAT_QR_CODE -> R.string.scan_format_qr_code
            Barcode.FORMAT_AZTEC -> R.string.scan_format_aztec
            Barcode.FORMAT_DATA_MATRIX -> R.string.scan_format_data_matrix
            Barcode.FORMAT_PDF417 -> R.string.scan_format_pdf
            Barcode.FORMAT_CODABAR -> R.string.scan_format_barcode
            Barcode.FORMAT_CODE_128 -> R.string.scan_format_code_128
            Barcode.FORMAT_CODE_93 -> R.string.scan_format_code_93
            Barcode.FORMAT_CODE_39 -> R.string.scan_format_code_39
            Barcode.FORMAT_EAN_13 -> R.string.scan_format_ean_13
            Barcode.FORMAT_EAN_8 -> R.string.scan_format_ean_8
            Barcode.FORMAT_ITF -> R.string.scan_format_itf
            Barcode.FORMAT_UPC_A -> R.string.scan_format_upc_a
            Barcode.FORMAT_UPC_E -> R.string.scan_format_upc_e
            else -> R.string.scan_format_unknown
        },
        scanType = if (valueType == Barcode.TYPE_URL) ScanType.Url else ScanType.Text
    )
}