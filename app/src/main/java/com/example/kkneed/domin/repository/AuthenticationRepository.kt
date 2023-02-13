package com.example.kkneed.domin.repository

import com.example.kkneed.domin.entities.Response
import kotlinx.coroutines.flow.Flow

interface AuthenticationRepository {
     fun isUserAuthenticatedInFirebase() : Boolean
     fun getFirebaseAuthState() : Flow<Boolean>
     fun firebaseSignOut() : Flow<Response<Boolean>>
     fun firebaseSignIn(email: String, password: String): Flow<Response<Boolean>>
     fun firebaseSignUp(
        email: String,
        password: String,
    ): Flow<Response<Boolean>>

}