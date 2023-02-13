package com.example.kkneed.model.repository

import com.example.kkneed.domin.entities.Response
import com.example.kkneed.domin.entities.User
import com.example.kkneed.domin.repository.AuthenticationRepository
import com.example.kkneed.network.NetworkConstant
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.BuildConfig
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@ExperimentalCoroutinesApi
class AuthenticationRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firebaseFirestore: FirebaseFirestore,
) : AuthenticationRepository {

    var operationSuccessful : Boolean = false
    override  fun isUserAuthenticatedInFirebase(): Boolean {
        return firebaseAuth.currentUser!=null
    }
    @ExperimentalCoroutinesApi
    override fun getFirebaseAuthState(): Flow<Boolean> = callbackFlow {
        val authStateListener = FirebaseAuth.AuthStateListener {
            trySend(firebaseAuth.currentUser == null)
        }
        firebaseAuth.addAuthStateListener(authStateListener)
        awaitClose{
            firebaseAuth.removeAuthStateListener(authStateListener)
        }
    }
    override  fun firebaseSignOut(): Flow<Response<Boolean>> = flow{
        try{
            emit(Response.Loading)
            firebaseAuth.signOut()
            emit(Response.Success(true))
        }
        catch(e:Exception){
            emit(Response.Error(e.localizedMessage?:"An Unexpected Error"))
        }
    }

    override  fun firebaseSignUp(
        email: String,
        password: String
    ): Flow<Response<Boolean>> =flow {
        operationSuccessful = false

        try {
            emit(Response.Loading)
            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
                operationSuccessful = true
            }.await()

            //emit(Response.Loading)

            //firebaseAuth.createUserWithEmailAndPassword(email.trim(), password)
                //.addOnSuccessListener {
                    //signUpSuccessful = true
                //}.await()


            if (operationSuccessful) {
                val userId = firebaseAuth.currentUser?.uid!!
                val obj = User(
                     email = email, password = password,
                    userId = userId
                )

                firebaseFirestore.collection(NetworkConstant.COLLECTION_NAME_USERS).document(userId)
                    .set(obj)
                    .addOnSuccessListener { }.await()
                emit(Response.Success(true))

            } else {
                Response.Success(operationSuccessful)
                //emit(Response.Error("Failed To SignUp"))
            }

        } catch (e: Exception) {

            emit(Response.Error(e.localizedMessage ?: "An Unexpected Error"))
        }

    }

    override fun firebaseSignIn(email: String, password: String): Flow<Response<Boolean>> =
        flow {

            operationSuccessful = false

            emit(Response.Loading)
            try{
                emit(Response.Loading)
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
                    operationSuccessful = true
                }.await()
                emit(Response.Success(operationSuccessful))
            }

            catch (e: Exception) {
                emit(Response.Error(e.localizedMessage ?: "An Unexpected Error"))
            }
        }
}