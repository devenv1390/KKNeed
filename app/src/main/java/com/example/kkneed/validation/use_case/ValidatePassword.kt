package com.example.kkneed.validation.use_case

import com.example.kkneed.R

class ValidatePassword {

    fun execute(password: String): ValidationResult {
        if(password.length < 8) {
            return ValidationResult(
                successful = false,
                errorMessage = "密码至少需要8个字符"
            )
        }
        val containsLettersAndDigits = password.any { it.isDigit() } &&
                password.any { it.isLetter() }
        if(!containsLettersAndDigits) {
            return ValidationResult(
                successful = false,
                errorMessage = "密码至少应该包含一个数字和一个字母"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}