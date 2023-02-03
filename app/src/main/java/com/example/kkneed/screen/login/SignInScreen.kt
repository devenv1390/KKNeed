package com.example.kkneed.screen.login

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TextField
import androidx.compose.material3.*
import androidx.compose.material3.TextFieldDefaults.indicatorLine
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.R
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.ui.GradientButton
import com.example.kkneed.ui.theme.KKNeedTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignInScreen(navController: NavController) {


    var email by remember {
        mutableStateOf("")
    }

    var passwordHidden by remember{ mutableStateOf(false)}

    var password by remember {
        mutableStateOf("")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = MaterialTheme.colorScheme.onPrimary)
    ) {


        Spacer(modifier = Modifier.height(30.dp))


        Spacer(modifier = Modifier.height(36.dp))
        Text(
            text = "欢迎回到康康星球！",
            color = MaterialTheme.colorScheme.onBackground,
            style =MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
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

        TextField(value = email,
            textStyle = TextStyle(color = Color.White, fontSize = 15.sp),
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(0.8f),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = MaterialTheme.colorScheme.primary),
            onValueChange =
            {

                email = it
                println("onValue Change Email $email")
            })

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
        TextField(value = password,
            textStyle = TextStyle(color =Color.White, fontSize = 15.sp),
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(0.8f),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = MaterialTheme.colorScheme.primary),

            onValueChange =
            {
                password = it
                println("onValue Change Password $password")
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        passwordHidden = !passwordHidden
                    }
                ){
                    Icon(painterResource(id = R.drawable.visibility), null)
                }
            },
        )


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
            textId = "登录", onClick = {println("Onclick Email $email")
                println("Onclick Passwod $password")}
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
                Icon(painterResource(id = R.drawable.weixin),null)

            }
            Spacer(modifier = Modifier.width(52.dp))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painterResource(id = R.drawable.qq),null)
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

@Composable
@Preview
fun SignUpScreenPreview() {
    KKNeedTheme {
        val navController = rememberNavController()
        SignInScreen(navController)
    }
}