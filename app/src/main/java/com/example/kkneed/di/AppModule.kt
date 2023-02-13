package com.example.kkneed.di

import com.example.kkneed.domin.repository.AuthenticationRepository
import com.example.kkneed.domin.use_cases.authentication.*
import com.example.kkneed.model.repository.AuthenticationRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideFirebaseStore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Singleton
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }




    @Singleton
    @Provides
    fun provideFirebaseStorage(): FirebaseStorage {
        return FirebaseStorage.getInstance()
    }

    @ExperimentalCoroutinesApi
    @Singleton
    @Provides
    fun provideAuthenticationRepository(
        firebaseAuth: FirebaseAuth,
        firebaseFirestore: FirebaseFirestore,
    ): AuthenticationRepository {
        return AuthenticationRepositoryImpl(
            firebaseAuth = firebaseAuth,
            firebaseFirestore = firebaseFirestore,
        )
    }


    @Singleton
    @Provides
    fun provideAuthenticationUseCase(repository: AuthenticationRepository) =
        AuthenticationUseCase(
            firebaseSignUp = FirebaseSignUp(repository = repository),
            firebaseSignIn = FirebaseSignIn(repository = repository),
            isUserAuthenticated = IsUserAuthenticated(repository = repository),
            firebaseAuthState = FirebaseAuthState(repository = repository),
            firebaseSignOut = FirebaseSignOut(repository = repository),
        )


}
