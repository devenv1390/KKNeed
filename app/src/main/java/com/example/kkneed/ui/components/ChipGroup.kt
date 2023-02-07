package com.example.kkneed.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.screen.shop.SearchResultScreen
import com.example.kkneed.ui.theme.KKNeedTheme
import com.example.kkneed.ui.theme.LevelE

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionChip(state:Boolean,title: String){
    var selected by remember { mutableStateOf(state) }
    FilterChip(
        selected = selected,
        onClick = { selected = !selected },
        label = { Text(title,
            color=if(selected) Color.White else Color.Black) },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = MaterialTheme.colorScheme.outline.copy(0.7f),
            selectedContainerColor = MaterialTheme.colorScheme.primary,

            ),

        border = FilterChipDefaults.filterChipBorder(borderWidth = 0.dp),
    )
}
//第二个问卷页chip
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallChip(state:Boolean,title: String,modifier: Modifier){
    var selected by remember { mutableStateOf(state) }
    FilterChip(
        modifier=modifier,
        selected = selected,
        onClick = { selected = !selected },
        label = { Text(title,
            color=if(selected) Color.White else Color.Black) },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = MaterialTheme.colorScheme.outline.copy(0.7f),
            selectedContainerColor = MaterialTheme.colorScheme.primary,
            ),
        border = FilterChipDefaults.filterChipBorder(borderWidth = 0.dp),
    )
}
//产品详情chip组
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailChip(state:Boolean,title:List<String>){


    Row(modifier = Modifier
        .padding(start = 16.dp, end = 16.dp)
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
    title.forEach{ item->
        FilterChip(
            selected = state,
            onClick = {  },
            label = { Text(item,
                color=Color.White) },
            colors = FilterChipDefaults.filterChipColors(
                containerColor = LevelE
            ),
            border = FilterChipDefaults.filterChipBorder(borderWidth = 0.dp),
        )
    }

    }
}
@Preview
@Composable
fun ChipScreen() {
    KKNeedTheme {

    }
}
