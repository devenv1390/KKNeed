package com.example.kkneed.validation.use_case

class ValidateRepeatedPassword {

    fun execute(password: String, repeatedPassword: String): ValidationResult {
        if(password != repeatedPassword) {
            return ValidationResult(
                successful = false,
                errorMessage = "两次输入的密码不一致"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}
