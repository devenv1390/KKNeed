package com.example.kkneed.ui.components

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kkneed.R
import com.example.kkneed.screen.login.RandomPosition
import com.example.kkneed.ui.theme.KKNeedTheme
import java.util.*
//正常长度文本框
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldDemo(title:String) {
    Column() {
        Row(modifier = Modifier
            .fillMaxWidth(0.8f)
            .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Start
        ){
            Text(
                text = title,
                color = MaterialTheme.colorScheme.outline,
                style = MaterialTheme.typography.titleMedium
            )}

        var text by remember{ mutableStateOf("")}


        androidx.compose.material3.TextField(value = text,
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(0.8f),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = MaterialTheme.colorScheme.primary
            ),
            onValueChange =
            {

                text = it
            })
    }
}
//个人页面中正常长度文本框
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTextFieldDemo(title:String) {
    Column() {
        Row(modifier = Modifier
            .fillMaxWidth(0.8f)
            .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Start
        ){
            Text(
                text = title,
                color = MaterialTheme.colorScheme.outline,
                style = MaterialTheme.typography.titleMedium
            )}

        var text by remember{ mutableStateOf("杨xx")}


        androidx.compose.material3.TextField(value = text,
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(0.8f),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = MaterialTheme.colorScheme.primary
            ),
            onValueChange =
            {

                text = it
            })
    }
}
//较短长度文本框
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldDemo1(title:String,unit:String) {
    Column() {
        Row(modifier = Modifier
            .fillMaxWidth(0.8f)
            .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Start
        ){
            Text(
                text = title,
                color = MaterialTheme.colorScheme.outline,
                style = MaterialTheme.typography.titleMedium
            )}

        var text by remember{ mutableStateOf("")}


        Row(modifier = Modifier
            .fillMaxWidth(0.8f),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            TextField(value = text,
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(0.6f),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = MaterialTheme.colorScheme.primary
            ),
            onValueChange =
            {

                text = it
            })
            Box(modifier =Modifier
                .background(color = MaterialTheme.colorScheme.tertiaryContainer,
                    shape =  RoundedCornerShape(20.dp))
                .size(90.dp,56.dp),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text=unit,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = Bold),
                    color = Color.White
                )
            }
        }

    }
}
//个人页面中较短长度文本框
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTextFieldDemo1(title:String,number:String,unit:String) {
    Column() {
        Row(modifier = Modifier
            .fillMaxWidth(0.8f)
            .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Start
        ){
            Text(
                text = title,
                color = MaterialTheme.colorScheme.outline,
                style = MaterialTheme.typography.titleMedium
            )}

        var text by remember{ mutableStateOf(number)}


        Row(modifier = Modifier
            .fillMaxWidth(0.8f),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            TextField(value = text,
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(0.6f),
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.primary
                ),
                onValueChange =
                {

                    text = it
                })
            Box(modifier =Modifier
                .background(color = MaterialTheme.colorScheme.tertiaryContainer,
                    shape =  RoundedCornerShape(20.dp))
                .size(90.dp,56.dp),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text=unit,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = Bold),
                    color = Color.White
                )
            }
        }

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IconTextField(title:String){
    Column() {
        Row(modifier = Modifier
            .fillMaxWidth(0.8f)
            .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Start
        ){
            Text(
                text = title,
                color = MaterialTheme.colorScheme.outline,
                style = MaterialTheme.typography.titleMedium
            )}

        var text by remember{ mutableStateOf("")}


        androidx.compose.material3.TextField(value = text,
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(0.8f),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = MaterialTheme.colorScheme.primary
            ),
            leadingIcon = { Icon(painterResource(id = R.drawable.calendar), null )},
            onValueChange =
            {

                text = it
            })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BirthTextField(title:String){
    Column() {
        val year: Int
        val month: Int
        val day: Int

        val calendar = Calendar.getInstance()
        year = calendar.get(Calendar.YEAR)
        month = calendar.get(Calendar.MONTH)
        day = calendar.get(Calendar.DAY_OF_MONTH)
        calendar.time = Date()

        val date = remember { mutableStateOf("") }
        val datePickerDialog = DatePickerDialog(
            LocalContext.current,
            { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                date.value = "$dayOfMonth/$month/$year"
            }, year, month, day
        )

        Row(modifier = Modifier
            .fillMaxWidth(0.8f)
            .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Start
        ){
            Text(
                text = title,
                color = MaterialTheme.colorScheme.outline,
                style = MaterialTheme.typography.titleMedium
            )}
            androidx.compose.material3.TextField(value = date.value,
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(0.8f)
                    ,
                readOnly = true,
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.primary
                ),
                leadingIcon = { Icon(painterResource(id = R.drawable.calendar),
                    null ,
                modifier = Modifier.clickable (onClick={
                    datePickerDialog.show()
                } ))},
                onValueChange =
                {
                    date.value=it
                })


    }
}
@Composable
@Preview
fun TextFieldPreview() {
    KKNeedTheme() {
        IconTextField(title = "生日")
    }
}



