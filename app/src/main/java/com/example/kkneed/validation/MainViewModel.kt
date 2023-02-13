package com.example.kkneed.validation

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kkneed.domin.entities.Response
import com.example.kkneed.domin.use_cases.authentication.AuthenticationUseCase
import com.example.kkneed.validation.event.RegistrationFormEvent
import com.example.kkneed.validation.state.RegistrationFormState
import com.example.kkneed.validation.use_case.ValidateEmail
import com.example.kkneed.validation.use_case.ValidatePassword
import com.example.kkneed.validation.use_case.ValidateRepeatedPassword
import com.example.kkneed.validation.use_case.ValidateTerms
import dagger.hilt.android.lifecycle.HiltViewModel
import com.google.firebase.firestore.BuildConfig
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class MainViewModel @Inject constructor(

    private val authenticationUseCase: AuthenticationUseCase,
): ViewModel() {

    val validateEmail: ValidateEmail = ValidateEmail()
    val validatePassword: ValidatePassword = ValidatePassword()
    val validateRepeatedPassword: ValidateRepeatedPassword = ValidateRepeatedPassword()
    val validateTerms: ValidateTerms = ValidateTerms()
    //val isUserAuthenticated get() = authenticationUseCase.isUserAuthenticated()

    private val _signUpState = mutableStateOf<Response<Boolean>>(Response.Success(false))
    val signUpState: State<Response<Boolean>> = _signUpState

    private val _signInState = mutableStateOf<Response<Boolean>>(Response.Success(false))
    val signInState: State<Response<Boolean>> = _signInState

    private val _signOutState = mutableStateOf<Response<Boolean>>(Response.Success(false))
    val signOutState : State<Response<Boolean>> = _signOutState

    private val _firebaseAuthState = mutableStateOf<Boolean>(false)
    val firebaseAuthState : State<Boolean> = _firebaseAuthState

    var state by mutableStateOf(RegistrationFormState())

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onEvent(event: RegistrationFormEvent) {
        when(event) {
            is RegistrationFormEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }
            is RegistrationFormEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }
            is RegistrationFormEvent.RepeatedPasswordChanged -> {
                state = state.copy(repeatedPassword = event.repeatedPassword)
            }
            is RegistrationFormEvent.AcceptTerms -> {
                state = state.copy(acceptedTerms = event.isAccepted)
            }
            is RegistrationFormEvent.Submit -> {
                submitData()
            }
        }
    }
    private fun submitData() {
        val emailResult = validateEmail.execute(state.email)
        val passwordResult = validatePassword.execute(state.password)
        val repeatedPasswordResult = validateRepeatedPassword.execute(
            state.password, state.repeatedPassword
        )
        val termsResult = validateTerms.execute(state.acceptedTerms)

        val hasError = listOf(
            emailResult,
            passwordResult,
            repeatedPasswordResult,
            termsResult
        ).any { !it.successful }

        if(hasError) {
            state = state.copy(
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage,
                repeatedPasswordError = repeatedPasswordResult.errorMessage,
                termsError = termsResult.errorMessage
            )
            return
        }
        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }

    fun signUp(email: String, password: String,) {


        viewModelScope.launch {


            authenticationUseCase.firebaseSignUp(
                email = email,
                password = password,
            ).collect {

                _signUpState.value = it
            }
        }

    }
    fun signIn(email: String, password: String) {

        viewModelScope.launch {

            authenticationUseCase.firebaseSignIn(email = email, password = password).collect { result ->

                when (result) {
                    is Response.Success -> {
                        //  authenticationUseCase.setUserStateInDataStore(isLoggedIn = true)
                    }

                    is Response.Error -> {
                        if (BuildConfig.DEBUG)
                            println(result.message)
                    }
                    is Response.Loading -> {
                    }
                }
                _signInState.value = result

            }
        }

    }


    sealed class ValidationEvent {
        object Success: ValidationEvent()
    }
}