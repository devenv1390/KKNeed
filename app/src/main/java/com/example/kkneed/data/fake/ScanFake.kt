package com.example.kkneed.data.fake

import com.example.kkneed.R
import com.example.kkneed.model.*

val fakeScan = Scan(
    displayValue = "123",
    scanFormatId = R.string.scan_format_qr_code,
    scanType = ScanType.Text
)

val fakeProduct = Product(
    "code",
    "name",
    "https://images.openfoodfacts.net/images/products/301/762/401/0701/front_en.54.100.jpg",
    "brands",
    "a",
    emptyList(),
    emptyList(),
    emptyList(),
    NutrientLevels("", "", "", ""),
    Nutriments(
        0.0,0.0,0.0,"",0.0,0.0,0.0,0.0,
        "",0.0,0.0,0.0,0.0,"",0.0,
        0.0,0.0,0.0,0.0,0.0,"",0.0,0.0,
        0.0,"",0.0,0.0,0.0,0.0,"",0.0,0.0,0.0,0.0,
        "",0.0,0.0,0.0,0.0,
        0.0,0.0,0.0,0.0,"",0.0,0.0,0.0,0.0,"",
        0.0,0.0,0.0,0.0,"",0.0,0.0,0.0,
        0.0,"",0.0,0.0,0.0,0.0,"",0.0,
    )
)

val fakeNutrientLevels = NutrientLevels("", "", "", "")

val fakeNutriments = Nutriments(
    0.0,0.0,0.0,"",0.0,0.0,0.0,0.0,
    "",0.0,0.0,0.0,0.0,"",0.0,
    0.0,0.0,0.0,0.0,0.0,"",0.0,0.0,
    0.0,"",0.0,0.0,0.0,0.0,"",0.0,0.0,0.0,0.0,
    "",0.0,0.0,0.0,0.0,
    0.0,0.0,0.0,0.0,"",0.0,0.0,0.0,0.0,"",
    0.0,0.0,0.0,0.0,"",0.0,0.0,0.0,
    0.0,"",0.0,0.0,0.0,0.0,"",0.0,
    )
