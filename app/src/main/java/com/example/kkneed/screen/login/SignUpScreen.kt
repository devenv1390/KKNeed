package com.example.kkneed.screen.login

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.datastore.dataStore
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
fun SignUpScreen(navController: NavController) {
    androidx.compose.material.Scaffold(
        backgroundColor = MaterialTheme.colorScheme.onPrimary,
        topBar = {
            MyTopAppBar2 {}
        },
    ) {
        var passwordHidden by remember{ mutableStateOf(false)}

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
                                "Signup successful",
                                Toast.LENGTH_LONG
                            ).show()
                            scope.launch {
                                dataStore.saveLogin(true)
                            }
                            navController.navigate(AllScreen.SignInfo.route)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(text = "Hello!欢迎来到康康星球！", color = MaterialTheme.colorScheme.onBackground,
                style =MaterialTheme.typography.titleMedium )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "让我们来创建一个新账号吧！",
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
                onValueChange =
                {
                    viewModel.onEvent(RegistrationFormEvent.EmailChanged(it))
                },
                isError = state.emailError != null)
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
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.Start
            ){
                Text(
                    text = "确认密码",
                    color = MaterialTheme.colorScheme.outline,
                    style =MaterialTheme.typography.titleMedium
                )
            }
            TextField(value = state.repeatedPassword,
                singleLine = true,
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(0.8f),
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.primary),
                isError = state.repeatedPasswordError != null,
                onValueChange =
                {
                    viewModel.onEvent(RegistrationFormEvent.RepeatedPasswordChanged(it))
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
            if (state.repeatedPasswordError != null) {
                Text(
                    text = state.repeatedPasswordError,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                )
            }

            Row(modifier=Modifier.fillMaxSize(0.8f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start){

                Checkbox(
                    checked = state.acceptedTerms,
                    onCheckedChange = { viewModel.onEvent(RegistrationFormEvent.AcceptTerms(it)) }
                )
                Text(
                    "我同意",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    "服务条款和隐私政策",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodySmall
                )
            }
            if (state.termsError != null) {
                Text(
                    text = state.termsError,
                    color = MaterialTheme.colorScheme.error ,
                    modifier = Modifier
                        .fillMaxWidth(0.8f),
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            GradientButton(modifier = Modifier
                .height(40.dp)
                .fillMaxWidth(0.8f),
                textId = "注册账号", onClick = {
                    viewModel.onEvent(RegistrationFormEvent.Submit)
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
                    "已经有账号了？",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyMedium
                )
                TextButton(
                    onClick = { navController.navigate(AllScreen.SignIn.route) },
                )
                {
                    Text("来登录吧！",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.bodyMedium)
                }
            }

        }
    }

}

@Composable
@Preview
fun SignInScreenPreview() {
    KKNeedTheme {
        val navController = rememberNavController()
        SignUpScreen(navController)
    }
}