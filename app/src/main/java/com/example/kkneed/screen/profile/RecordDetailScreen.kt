package com.example.kkneed.screen.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kkneed.R
import com.example.kkneed.ui.CollectTabBar
import com.example.kkneed.ui.MostUseTopAppBar
import com.example.kkneed.ui.RecordDetailList
import com.example.kkneed.ui.theme.KKNeedTheme
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RecordDetailScreen(navController: NavController) {
    Scaffold(
        topBar = {
            MostUseTopAppBar(appBarHeight = 64.dp, navController =navController, "记录详情")
        },
        floatingActionButton = {
            FloatingActionButton(shape = RoundedCornerShape(12.dp), modifier = Modifier.padding(bottom=20.dp),onClick = {
                 }) {
                Icon(
                    Icons.Default.Add,
                    null, tint = Color.White)
            }}
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)){
            item{ RecordDetailList("麦维他纤维饼干") }
            item{ RecordDetailList("麦维他纤维饼干") }
            item{ RecordDetailList("麦维他纤维饼干") }
            item{ RecordDetailList("麦维他纤维饼干") }
            item{ RecordDetailList("麦维他纤维饼干") }
            item{ RecordDetailList("麦维他纤维饼干") }

        }
    }
}

@Preview
@Composable
fun Pre(){
    KKNeedTheme {
        val navController = rememberNavController()
        RecordDetailScreen(navController)
    }
}