package com.example.kkneed.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar() {
    var text by remember { mutableStateOf("") }
    Box(contentAlignment = Alignment.Center) {
        BasicTextField(
            value = text,
            onValueChange = { text = it },
            decorationBox = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "")
                    Box(
                        modifier = Modifier.padding(horizontal = 10.dp).weight(1f),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        if (text.isEmpty()) {
                            Text(
                                text = "输入点东西康康吧~",
                                style = TextStyle(Color(0, 0, 0, 128))
                            )
                        }
                        it()
                    }
                    if (text.isNotEmpty()) {
                        IconButton(onClick = { text = "" }, modifier = Modifier.size(16.dp)) {
                            Icon(imageVector = Icons.Filled.Close, contentDescription = "")
                        }
                    }
                }
            },
            modifier = Modifier
                .padding(10.dp)
                .background(MaterialTheme.colorScheme.secondaryContainer, shape = RoundedCornerShape(12.dp))
                .size(270.dp,40.dp)
        )
    }
}