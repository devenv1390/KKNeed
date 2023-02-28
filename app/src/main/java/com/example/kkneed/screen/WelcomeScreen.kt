package com.example.kkneed.screen

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import android.widget.Toast
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import cn.jiguang.verifysdk.api.AuthPageEventListener
import cn.jiguang.verifysdk.api.JVerificationInterface
import cn.jiguang.verifysdk.api.JVerifyUIConfig
import cn.jiguang.verifysdk.api.LoginSettings
import com.example.kkneed.R
import com.example.kkneed.datastore.StoreUserLogin
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.ui.MyTopAppBar
import com.example.kkneed.ui.MyTopAppBar2
import com.example.kkneed.ui.theme.KKNeedTheme
import com.example.kkneed.validation.event.RegistrationFormEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WelcomeScreen(navController: NavController) {
    val context = LocalContext.current
    val scope= rememberCoroutineScope()

    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        oneKeyLogin(context )
        handlerOneKeyLogin(context,navController,scope)
        //navController.navigate(AllScreen.SignUp.route)
    }
    Splash(alpha = alphaAnim.value)

}
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Splash(alpha: Float) {


    Scaffold(backgroundColor = MaterialTheme.colorScheme.onPrimary,
        topBar = {
            MyTopAppBar2{}
        },) {
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.onPrimary),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier
                        .size(120.dp)
                        .alpha(alpha = alpha),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo Icon",
                    tint = Color.Unspecified
                )
            }
            Row(modifier= Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center){

                androidx.compose.material3.Text(
                    "KKNeed",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.displaySmall
                )
            }
            Row(modifier= Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center){

                androidx.compose.material3.Text(
                    "选择我们，就是选择健康",
                    color = MaterialTheme.colorScheme.outline,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}
fun handlerOneKeyLogin(context: Context,navController: NavController,scope:CoroutineScope) {
    // 配置 Login Setting
    customUIStyle()
    val dataStore= StoreUserLogin(context)
    val settings = LoginSettings()
    settings.isAutoFinish = true // 登录完成后自动关闭授权页
    settings.timeout = 15 * 1000 // 设置超时时间，单位毫秒。 合法范围（0，30000],范围以外默认设置为10000
    settings.authPageEventListener = object : AuthPageEventListener() {
        override fun onEvent(cmd: Int, msg: String?) {
            Log.e(ContentValues.TAG, "===> onEvent code:$cmd msg:$msg")
        }
    }
    // 开始一键登录
    JVerificationInterface.loginAuth(
        context, settings
    ) { code, content, operator ->
        when (code) {
            6000 -> { // Login Token 获取成功
                Log.d(ContentValues.TAG, "code= $code token= $content operator= $operator")
                navController.navigate(AllScreen.Guide.route)
                scope.launch {
                    dataStore.saveLogin(true)
                }
            }
            else -> {
                Log.d(ContentValues.TAG, "codee= $code message= $content")
                Toast.makeText(context, "登录失败，请选择账号密码注册或登录", Toast.LENGTH_SHORT).show()
                navController.navigate(AllScreen.SignUp.route)
            }
        }
        //tv_login_result.text = "code：$code \n content：$content \n operator：$operator"
    }
}
fun oneKeyLogin(context: Context) {
    JVerificationInterface.setLocationEanable(context,true)
    // 检查当前是否初始化成功极光 SDK
    if (JVerificationInterface.isInitSuccess()) {
        // 判断当前的手机网络环境是否可以使用认证。
        if (!JVerificationInterface.checkVerifyEnable(context)) {
            Toast.makeText(context, "[2016],msg = 当前网络环境不支持认证", Toast.LENGTH_SHORT).show()
            return
        }
    } else {
        Toast.makeText(context, "极光 SDK 尚未初始化成功～！", Toast.LENGTH_SHORT).show()
    }
}
fun customUIStyle(){
    val uiConfig = JVerifyUIConfig.Builder()
        .setNavColor(0x00FFFF)
        .setPrivacyTextCenterGravity(true)

    JVerificationInterface.setCustomUIWithConfig(uiConfig.build())
}

@Composable
@Preview
fun SplashScreenPreview() {
    KKNeedTheme() {
        Splash(alpha = 1f)
    }

}
