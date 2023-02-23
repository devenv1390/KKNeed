package com.example.kkneed.screen.profile

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Settings
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.R
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.screen.login.LabelScreen
import com.example.kkneed.ui.GradientButton
import com.example.kkneed.ui.MostUseTopAppBar
import com.example.kkneed.ui.components.*
import com.example.kkneed.ui.theme.KKNeedTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PersonInfoScreen(navController: NavController) {
    val context= LocalContext.current
    Scaffold(
        topBar = {
            MostUseTopAppBar(appBarHeight = 64.dp, navController =navController, "我的信息")
        },
        bottomBar = {
            Column {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center){
                    GradientButton(modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth(0.8f),
                        textId = "更新信息", onClick = {
                            Toast.makeText(
                                context,
                                "更新信息成功！",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    )
                }
                Spacer(modifier = Modifier.height(40.dp))
            }
        }

    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(color = MaterialTheme.colorScheme.onPrimary)
        ){
            Spacer(modifier = Modifier.height(30.dp))
            Box(modifier = Modifier.size(110.dp)) {
                Image(
                    painter = painterResource(R.drawable.head),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(24.dp))
                        .size(95.dp),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.TopCenter,
                )
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                ) {
                    Surface(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = RoundedCornerShape(50),
                        modifier = Modifier
                            .size(30.dp)
                    ) {
                        Box(modifier = Modifier.size(20.dp), contentAlignment = Alignment.Center)
                        {
                            Icon(Icons.Sharp.Settings, null, tint = MaterialTheme.colorScheme.onBackground)
                        }

                    }
                }

            }
            Text(text = "康康", color = MaterialTheme.colorScheme.onBackground,
                style =MaterialTheme.typography.titleMedium )
            Text(
                text = "康康ID：1234567",
                color = MaterialTheme.colorScheme.onBackground,
                style =MaterialTheme.typography.labelSmall
            )
            Spacer(modifier = Modifier.height(5.dp))
            ProfileTextFieldDemo("姓名")
            Spacer(modifier = Modifier.height(8.dp))
            var state by remember { mutableStateOf(true) }
            Row(modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.Start
            ){
                Text(
                    text = "性别",
                    color = MaterialTheme.colorScheme.outline,
                    style =MaterialTheme.typography.titleMedium
                )
            }
            Row(Modifier.selectableGroup(),
                verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = state,
                    onClick = { state = false},
                    modifier = Modifier.semantics { contentDescription = "Localized Description" }
                )
                Text("男",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(120.dp))
                RadioButton(
                    selected = !state,
                    onClick = { state = true },
                    modifier = Modifier.semantics { contentDescription = "Localized Description" }
                )
                Text("女",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )
            }

            BirthTextField(title = "生日")
            Spacer(modifier = Modifier.height(12.dp))
            ProfileTextFieldDemo1("身高","170","CM")
            Spacer(modifier = Modifier.height(12.dp))
            ProfileTextFieldDemo1("体重","50","KG")
            Spacer(modifier = Modifier.height(24.dp))
        }
    }

}
@Composable
@Preview
fun PersonInfoScreenPreview() {
    KKNeedTheme {
        val navController = rememberNavController()
        PersonInfoScreen(navController)
    }
}