package com.example.kkneed.ui.components

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kkneed.R
import com.example.kkneed.ui.CommentCard
import com.example.kkneed.ui.ImageCommentCard
import com.example.kkneed.ui.ShopScreenMainCard
import com.example.kkneed.ui.theme.KKNeedTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


//第二个问卷页chip
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallChip(state: Boolean, title: String, modifier: Modifier) {
    var selected by remember { mutableStateOf(state) }
    FilterChip(
        modifier = modifier,
        selected = selected,
        onClick = { selected = !selected },
        label = {
            Text(
                title,
                color = if (selected) Color.White else Color.Black
            )
        },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = MaterialTheme.colorScheme.outline.copy(0.7f),
            selectedContainerColor = MaterialTheme.colorScheme.primary,
        ),
        border = FilterChipDefaults.filterChipBorder(borderWidth = 0.dp),
    )
}

//过敏原chip
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllergicChip(state: Boolean, title: String, modifier: Modifier, onClick: () -> Unit) {
    var selected by remember { mutableStateOf(state) }
    FilterChip(
        modifier = modifier,
        selected = selected,
        onClick = { selected = !selected },
        label = {
            Text(
                title,
                color = if (selected) Color.White else Color.Black
            )
        },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = MaterialTheme.colorScheme.outline.copy(0.7f),
            selectedContainerColor = MaterialTheme.colorScheme.primary,
        ),
        border = FilterChipDefaults.filterChipBorder(borderWidth = 0.dp),
    )
}

//定制页chip
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomizeChip(title: String, modifier: Modifier) {

    FilterChip(
        modifier = modifier,
        selected = true,
        onClick = {},
        label = {
            Text(
                title,
                color = MaterialTheme.colorScheme.onBackground
            )
        },
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
        border = FilterChipDefaults.filterChipBorder(borderWidth = 0.dp),
    )
}

//产品详情chip组
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailChip(state: Boolean, title: List<String>) {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        title.forEach { item ->
            FilterChip(
                selected = state,
                onClick = { },
                label = {
                    Text(
                        item,
                        color = Color.White
                    )
                },
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                border = FilterChipDefaults.filterChipBorder(borderWidth = 0.dp),
            )
        }
    }
}

//定制页chip组
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomizeInfoChip(state: Boolean, title: String) {
    var selected by remember { mutableStateOf(state) }
    FilterChip(
        selected = selected,
        onClick = { selected = !selected },
        label = {
            Text(
                title, style = MaterialTheme.typography.bodySmall,
                color = if (selected) MaterialTheme.colorScheme.onBackground else
                    MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = Color.White,
            selectedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
        border = FilterChipDefaults.filterChipBorder(borderWidth = 1.dp, selectedBorderWidth = 0.dp),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionChip(state: Boolean, title: String) {
    var selected by remember { mutableStateOf(state) }
    FilterChip(
        selected = selected,
        onClick = { selected = !selected },
        label = {
            Text(
                title,
                color = if (selected) Color.White else Color.Black
            )
        },
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
    val coroutineScope = rememberCoroutineScope()


    val chipList: List<String> = listOf(
        "全部",
        "最新",
        "有图"
    )

    var selected by remember { mutableStateOf(true) }

    Row(
        modifier = Modifier
            .padding(start = 8.dp, top = 8.dp, bottom = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        chipList.forEachIndexed() { index, it ->
            FilterChip(selected = pagerState.currentPage == index,
                label = {
                    Text(
                        it,
                        color = if (selected) Color.White else Color.Black
                    )
                },
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = MaterialTheme.colorScheme.outline.copy(0.7f),
                    selectedContainerColor = MaterialTheme.colorScheme.primary,
                ),
                border = FilterChipDefaults.filterChipBorder(borderWidth = 0.dp),
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )

        }

    }
    HorizontalPager(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 56.dp),
        count = 3,
        state = pagerState,
    ) { page ->
        when (page) {
            0 -> {
                androidx.compose.material.Surface(color = MaterialTheme.colorScheme.background) {
                    LazyColumn(
                        Modifier
                            .fillMaxSize()
                            .padding(top = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    )
                    {
                        item { CommentCard() }
                        item { CommentCard() }
                        item { ImageCommentCard() }
                        item { CommentCard() }
                        item { ImageCommentCard() }
                        item { ImageCommentCard() }
                        item { CommentCard() }
                        item { CommentCard() }
                        item { CommentCard() }
                        item { ImageCommentCard() }
                        item { CommentCard() }
                        item { ImageCommentCard() }
                        item { ImageCommentCard()}
                        item { CommentCard() }
                        item{Spacer(modifier = Modifier.height(16.dp))}

                    }
                }
            }

            1 -> {
                androidx.compose.material.Surface(color = MaterialTheme.colorScheme.background) {
                    LazyColumn(
                        Modifier
                            .fillMaxSize()
                            .padding(top = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    )
                    {
                        item { CommentCard() }
                        item { CommentCard() }
                        item { CommentCard() }
                        item { ImageCommentCard() }
                        item { CommentCard() }
                        item{Spacer(modifier = Modifier.height(16.dp))}
                    }
                }
            }

            2 -> {
                androidx.compose.material.Surface(color = MaterialTheme.colorScheme.background) {
                    LazyColumn(
                        Modifier
                            .fillMaxSize()
                            .padding(top = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    )
                    {
                        item { ImageCommentCard() }
                        item { ImageCommentCard() }
                        item { ImageCommentCard() }
                        item { ImageCommentCard()}
                        item{Spacer(modifier = Modifier.height(16.dp))}
                    }
                }
            }
        }

    }
}

@SuppressLint("ResourceType", "SupportAnnotationUsage")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun ShopIconGroupCompose(navController: NavController) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    val chipList: List<String> = listOf(
        "健身餐",
        "面包",
        "饮品",
        "烹饪",
        "零食"
    )
    @StringRes val imageIdList: List<Int> = listOf(
        R.drawable.meal,
        R.drawable.bakery,
        R.drawable.cafe,
        R.drawable.soup,
        R.drawable.pizza
    )

    var selected by remember { mutableStateOf(true) }

    Row(
        modifier = Modifier
            .padding(start = 16.dp, top = 8.dp, bottom = 8.dp, end = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        chipList.forEachIndexed() { index, it ->
            FilterChip(selected = pagerState.currentPage == index,
                modifier = Modifier.size(64.dp, 72.dp)
                    .padding(vertical = 4.dp),
                label = {},
                leadingIcon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(imageIdList[index]), null,
                            modifier = Modifier.size(36.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )

                        androidx.compose.material3.Text(
                            it,
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                },
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = Color.Transparent,
                    selectedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                ),
                border = FilterChipDefaults.filterChipBorder(
                    borderColor = Color.Transparent,
                    selectedBorderColor = Color.Transparent
                ),
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )

        }

    }
    HorizontalPager(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp),
        count = 5,
        state = pagerState,
        userScrollEnabled = true,
    ) { page ->
        androidx.compose.material.Surface(color = MaterialTheme.colorScheme.background) {
            LazyColumn(
                Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            )
            {
                item { ShopScreenMainCard(navController) }
                item { ShopScreenMainCard(navController) }
                item { ShopScreenMainCard(navController) }
                item { ShopScreenMainCard(navController) }
                item { ShopScreenMainCard(navController) }
                item { ShopScreenMainCard(navController) }
                item { ShopScreenMainCard(navController) }
                item { ShopScreenMainCard(navController) }
                item { ShopScreenMainCard(navController) }
                item { ShopScreenMainCard(navController) }
                item { Spacer(modifier = Modifier.height(88.dp)) }
            }
        }

    }
}


@Composable
fun Chip(
    title: String,
    selected: String,
    onSelected: (String) -> Unit,
    onClick: () -> Unit
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
    }
}
