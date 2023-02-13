package com.example.kkneed.validation.use_case

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null
)