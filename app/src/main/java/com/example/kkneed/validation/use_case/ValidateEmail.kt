package com.example.kkneed.validation.use_case

import android.util.Patterns

class ValidateEmail {
    fun execute(email: String): ValidationResult {
        if(email.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "请填写您的邮箱"
            )
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                successful = false,
                errorMessage = "请输入有效的电子邮件地址"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}