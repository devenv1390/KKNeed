package com.example.kkneed.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.navigation.SCANNER_ROUTE
import com.example.kkneed.navigation.ScannerDirection
import com.example.kkneed.screen.search.*

fun NavGraphBuilder.SearchNavGraph(navController: NavController) {
    navigation(
        startDestination = AllScreen.Scanner.route,
        route = SCANNER_ROUTE,
    ) {
        composable(AllScreen.Scanner.route) {
            BCScannerScreen(navController)
        }
        composable(
            AllScreen.ScanResult.route,
            arguments = ScannerDirection.argumentsList
        ) {
            val (code,codeType) = ScannerDirection.parseArguments(it)
            ScanResultScreen(navController,code,codeType)
        }
        composable(AllScreen.Comment.route) {
            CommentScreen(navController)
        }
        composable(AllScreen.Detail.route) {
            DetailScreen(navController)
        }
        composable(AllScreen.Compare.route) {
            CompareScreen(navController)
        }
        composable(AllScreen.ScanHistory.route) {
            ScanHistoryScreen(navController)
        }
        composable(AllScreen.Chose.route) {
            ChoseScreen(navController )
        }
        composable(AllScreen.Edit.route) {
            EditScreen(navController )
        }
        composable(AllScreen.EditProduct.route) {
            EditProductScreen(navController )
        }
    }
}