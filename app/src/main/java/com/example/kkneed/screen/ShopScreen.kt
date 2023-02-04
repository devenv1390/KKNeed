package com.example.kkneed.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.R
import com.example.kkneed.ui.ShopScreenMainCard
import com.example.kkneed.ui.ShopTopAppBar
import com.example.kkneed.ui.theme.KKNeedTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ShopScreen(navController: NavController) {
    Scaffold(
        backgroundColor = MaterialTheme.colorScheme.background,
        topBar = {
            ShopTopAppBar(appBarHeight = 64.dp, navController = navController)
        }
    ) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.shopcard),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(0))
                        .height(200.dp),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.TopCenter,
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .height(64.dp)
                        .fillMaxWidth(),
                ) {
                    QuickClassifyButton()
                }
                LazyColumn() {
                    item { ShopScreenMainCard() }
                    item { ShopScreenMainCard() }
                    item { ShopScreenMainCard() }
                    item { ShopScreenMainCard() }
                    item { ShopScreenMainCard() }
                    item { ShopScreenMainCard() }
                    item { ShopScreenMainCard() }
                    item { ShopScreenMainCard() }
                    item { ShopScreenMainCard() }
                    item { ShopScreenMainCard() }
                }
            }
        }
    }
}

@Composable
fun QuickClassifyButton() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .width(364.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        QuickClassifyInSide("健身")
        Spacer(modifier = Modifier.width(30.dp))
        QuickClassifyInSide("面包")
        Spacer(modifier = Modifier.width(30.dp))
        QuickClassifyInSide("饮品")
        Spacer(modifier = Modifier.width(30.dp))
        QuickClassifyInSide("烹饪")
        Spacer(modifier = Modifier.width(30.dp))
        QuickClassifyInSide("零食")
    }
}

@Composable
fun QuickClassifyInSide(strIconName: String) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .height(64.dp)
            .width(48.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        IconButton(
            onClick = {},
            modifier = Modifier.size(48.dp),

            ) {
            Icon(
                Icons.Outlined.Face, null,
                modifier = Modifier.size(48.dp),

                )
        }
        androidx.compose.material3.Text(
            strIconName,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}
@Preview
@Composable
fun PreviewShopScreen() {
    KKNeedTheme {
        val navController = rememberNavController()
        ShopScreen(navController)
    }
}
