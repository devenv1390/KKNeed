package com.example.kkneed.validation.use_case

import com.example.kkneed.R


class ValidateTerms {

    fun execute(acceptedTerms: Boolean): ValidationResult {
        if(!acceptedTerms) {
            return ValidationResult(
                successful = false,
                errorMessage = "请接受协议"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}