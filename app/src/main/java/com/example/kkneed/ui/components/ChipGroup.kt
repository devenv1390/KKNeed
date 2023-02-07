package com.example.kkneed.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.screen.shop.SearchResultScreen
import com.example.kkneed.ui.theme.KKNeedTheme
import com.example.kkneed.ui.theme.LevelE
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState


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
@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun ChipGroupCompose() {
    val pagerState = rememberPagerState()
    val chipList: List<String> = listOf(
        "全部",
        "最新",
        "有图"
    )

    var selected by remember { mutableStateOf("全部") }

    Row(
        modifier = Modifier
            .padding(start = 16.dp,top=8.dp)
            .fillMaxWidth()
    ) {
        chipList.forEach { it ->
            Chip(
                title = it,
                selected = selected,
                onSelected = {
                    selected = it
                }
            )
        }

        }
    HorizontalPager(
        modifier = Modifier.fillMaxWidth(),
        count = 3,
        state = pagerState,
    ){

    }
}




@Composable
fun Chip(
    title: String,
    selected: String,
    onSelected: (String) -> Unit
) {

    val isSelected = selected == title

    val background = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline.copy(0.7f)
    val contentColor = if (isSelected) Color.White else Color.Black

    Box(
        modifier = Modifier
            .padding(end = 10.dp)
            .height(40.dp)
            .clip(CircleShape)
            .background(background)
            .clickable(
                onClick = {
                    onSelected(title)
                }
            )
    ) {
        Row(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            AnimatedVisibility(visible = isSelected) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "check",
                    tint = Color.White
                )
            }

            Text(text = title, color = contentColor, fontSize = 16.sp)

        }
    }

}

@Preview
@Composable
fun ChipScreen() {
    KKNeedTheme {
        ChipGroupCompose()
    }
}
