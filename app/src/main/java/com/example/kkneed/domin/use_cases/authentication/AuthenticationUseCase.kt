package com.example.kkneed.domin.use_cases.authentication

data class AuthenticationUseCase(
    val isUserAuthenticated: IsUserAuthenticated,
    val firebaseAuthState: FirebaseAuthState,
    val firebaseSignOut: FirebaseSignOut,
    val firebaseSignUp: FirebaseSignUp,
    val firebaseSignIn: FirebaseSignIn,
)
