package com.example.kkneed.validation.use_case

class ValidateTerms {

    fun execute(acceptedTerms: Boolean): ValidationResult {
        if(!acceptedTerms) {
            return ValidationResult(
                successful = false,
                errorMessage = "接受隐私协议才可使用APP喔"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}