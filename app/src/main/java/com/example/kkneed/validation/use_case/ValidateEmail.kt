package com.example.kkneed.validation.use_case

import android.util.Patterns


class ValidateEmail {

    fun execute(email: String): ValidationResult {
        if(email.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "请输入您的邮箱"
            )
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                successful = false,
                errorMessage = "这不是一个合法的邮箱格式噢"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}