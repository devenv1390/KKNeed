package com.example.kkneed.screen.login

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.ui.GradientButton
import com.example.kkneed.ui.MyTopAppBar2
import com.example.kkneed.ui.components.BirthTextField
import com.example.kkneed.ui.components.IconTextField
import com.example.kkneed.ui.components.TextFieldDemo
import com.example.kkneed.ui.components.TextFieldDemo1
import com.example.kkneed.ui.theme.KKNeedTheme
import java.util.*


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun InfoScreen(navController:NavController) {
    androidx.compose.material.Scaffold(
        backgroundColor = MaterialTheme.colorScheme.onPrimary,
        topBar = {
            MyTopAppBar2 {}
        },
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(color = MaterialTheme.colorScheme.onPrimary)
        ) {


            Spacer(modifier = Modifier.height(65.dp))

            Text(
                text = "??????????????????",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(13.dp))
            Text(text = "???????????????????????????????????????", color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleMedium )

            Spacer(modifier = Modifier.height(20.dp))
            TextFieldDemo("??????")
            Spacer(modifier = Modifier.height(8.dp))
            var state by remember { mutableStateOf(true) }
            Row(modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.Start
            ){
                Text(
                    text = "??????",
                    color = MaterialTheme.colorScheme.outline,
                    style =MaterialTheme.typography.titleMedium
                )
            }
            Row(Modifier.selectableGroup(),
                verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = state,
                    onClick = { state = true },
                    modifier = Modifier.semantics { contentDescription = "Localized Description" }
                )
                Text("???",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(120.dp))
                RadioButton(
                    selected = !state,
                    onClick = { state = false },
                    modifier = Modifier.semantics { contentDescription = "Localized Description" }
                )
                Text("???",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )
            }

            BirthTextField(title = "??????")
            Spacer(modifier = Modifier.height(12.dp))
            TextFieldDemo1("??????","CM")
            Spacer(modifier = Modifier.height(12.dp))
            TextFieldDemo1("??????","KG")
            Spacer(modifier = Modifier.height(24.dp))
            GradientButton(modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(0.8f),
                textId = "????????? >", onClick = {
                    navController.navigate(AllScreen.Label.route)
                }
            )
            Spacer(modifier = Modifier.height(36.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {

                Text(
                    "????????????????????????",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyMedium
                )
                TextButton(
                    onClick = {navController.navigate(AllScreen.Success.route)  },
                )
                {
                    Text("??????????????????",
                        color = MaterialTheme.colorScheme.outline,
                        style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }

}
@Composable
@Preview
fun InfoScreenPreview() {
    KKNeedTheme {
        val navController = rememberNavController()
        InfoScreen(navController)
    }
}