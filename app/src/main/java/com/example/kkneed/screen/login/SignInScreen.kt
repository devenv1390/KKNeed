package com.example.kkneed.screen.login

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.R
import com.example.kkneed.datastore.StoreUserLogin
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.ui.GradientButton
import com.example.kkneed.ui.MyTopAppBar2
import com.example.kkneed.ui.theme.KKNeedTheme
import com.example.kkneed.viewmodel.MainViewModel
import com.example.kkneed.validation.event.RegistrationFormEvent
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignInScreen(navController: NavController) {
    androidx.compose.material.Scaffold(
        backgroundColor = MaterialTheme.colorScheme.onPrimary,
        topBar = {
            MyTopAppBar2 {}
        },
    ){
        var email by remember {
            mutableStateOf("")
        }

        var passwordHidden by remember{ mutableStateOf(false)}

        var password by remember {
            mutableStateOf("")
        }
        val icon=if(passwordHidden)
            painterResource(id =R.drawable.visibility )
        else painterResource(id =R.drawable.visibilityoff )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(color = MaterialTheme.colorScheme.onPrimary)
        ) {
            val viewModel = viewModel<MainViewModel>()
            val state = viewModel.state
            val context = LocalContext.current
            val scope= rememberCoroutineScope()
            val dataStore= StoreUserLogin(context)
            LaunchedEffect(key1 = context) {
                viewModel.validationEvents.collect { event ->
                    when (event) {
                        is MainViewModel.ValidationEvent.Success -> {
                            Toast.makeText(
                                context,
                                "登录成功！",
                                Toast.LENGTH_LONG
                            ).show()
                            scope.launch {
                                dataStore.saveLogin(true)
                            }
                            navController.navigate(AllScreen.Home.route)
                        }
                    }
                }
            }


            Spacer(modifier = Modifier.height(56.dp))
            Text(
                text = "欢迎回到康康星球！",
                color = MaterialTheme.colorScheme.onBackground,
                style =MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )

            Spacer(modifier = Modifier.height(30.dp))
            Row(modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.Start
            ){
                Text(
                    text = "邮箱",
                    color = MaterialTheme.colorScheme.outline,
                    style =MaterialTheme.typography.titleMedium
                )
            }

            TextField(value =state.email,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true,
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(0.8f),
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.primary),
                isError = state.emailError != null,
                onValueChange =
                {
                    viewModel.onEvent(RegistrationFormEvent.EmailChanged(it))
                })
            if (state.emailError != null) {
                Text(
                    text = state.emailError,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.Start
            ){
                Text(
                    text = "密码",
                    color = MaterialTheme.colorScheme.outline,
                    style =MaterialTheme.typography.titleMedium
                )
            }
            TextField(value = state.password,
                singleLine = true,
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(0.8f),
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.primary),
                isError = state.passwordError != null,
                onValueChange =
                {
                    viewModel.onEvent(RegistrationFormEvent.PasswordChanged(it))
                },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            passwordHidden = !passwordHidden
                        }
                    ){
                        Icon(painter = icon, contentDescription =null )
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if(passwordHidden) VisualTransformation.None else PasswordVisualTransformation()
            )
            if (state.passwordError != null) {
                Text(
                    text = state.passwordError,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))
            Text(
                "忘记密码？",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodySmall
            )


            Spacer(modifier = Modifier.height(24.dp))

            GradientButton(modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(0.8f),
                textId = "登录", onClick = {
                    viewModel.onEvent(RegistrationFormEvent.SubmitSignIn)
                //navController.navigate(AllScreen.Home.route)
                    }
            )



            Spacer(modifier = Modifier.height(35.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically){
                Box(modifier = Modifier
                    .size(141.dp, 1.dp)
                    .background(color = MaterialTheme.colorScheme.outline)
                )

                Text(
                    "Or",
                    modifier=Modifier.padding(start = 10.dp,end=10.dp),
                    color = MaterialTheme.colorScheme.outline,
                    style = MaterialTheme.typography.labelMedium
                )
                Box(modifier = Modifier
                    .size(141.dp, 1.dp)
                    .background(color = MaterialTheme.colorScheme.outline)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(){
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painterResource(id = R.drawable.weixin),null,tint = Color.Unspecified)

                }
                Spacer(modifier = Modifier.width(52.dp))
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painterResource(id = R.drawable.qq),null,tint = Color.Unspecified)
                }
            }
            Spacer(modifier = Modifier.height(25.dp))


            Row(verticalAlignment = Alignment.CenterVertically) {

                Text(
                    "还没有账号？",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyMedium
                )
                TextButton(onClick = { navController.navigate(AllScreen.SignUp.route)},
                )
                {
                    Text("来注册一个吧！",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.bodyMedium)
                }
            }

        }
    }


}

@Composable
@Preview
fun SignUpScreenPreview() {
    KKNeedTheme {
        val navController = rememberNavController()
        SignInScreen(navController)
    }
}