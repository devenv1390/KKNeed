package com.example.kkneed.domin.use_cases.authentication

import com.example.kkneed.domin.repository.AuthenticationRepository
import javax.inject.Inject

class IsUserAuthenticated @Inject constructor(
    private val repository: AuthenticationRepository
){
    operator fun invoke() = repository.isUserAuthenticatedInFirebase()
}