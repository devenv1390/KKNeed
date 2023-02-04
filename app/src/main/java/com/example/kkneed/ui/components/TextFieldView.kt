package com.example.kkneed.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kkneed.R
import com.example.kkneed.ui.theme.KKNeedTheme

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

@Composable
@Preview
fun TextFieldPreview() {
    KKNeedTheme() {
        IconTextField(title = "生日")
    }
}



