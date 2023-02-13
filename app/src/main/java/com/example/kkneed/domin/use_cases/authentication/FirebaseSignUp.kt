package com.example.kkneed.domin.use_cases.authentication

import com.example.kkneed.domin.repository.AuthenticationRepository
import javax.inject.Inject

class FirebaseSignUp @Inject constructor(
    private val repository: AuthenticationRepository
) {
    operator fun invoke(email: String, password: String) =
        repository.firebaseSignUp(email = email, password = password)
}