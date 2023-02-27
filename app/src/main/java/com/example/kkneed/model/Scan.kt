package com.example.kkneed.model

import androidx.annotation.StringRes

data class Scan(
    val displayValue: String,
    @StringRes val scanFormatId: Int,
    val scanType: ScanType
)

enum class ScanType {//不是TEXT类型就是URL类型
    Text,
    Url
}
