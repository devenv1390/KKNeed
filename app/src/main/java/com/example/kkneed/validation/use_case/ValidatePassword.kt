package com.example.kkneed.validation.use_case

class ValidatePassword {
    fun execute(password: String): ValidationResult {
        if(password.length < 8) {
            return ValidationResult(
                successful = false,
                errorMessage = "密码长度应大于7位"
            )
        }
        val containsLettersAndDigits = password.any { it.isDigit() } &&
                password.any { it.isLetter() }
        if(!containsLettersAndDigits) {
            return ValidationResult(
                successful = false,
                errorMessage = "密码需要包含至少一个字母和一个数字"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}