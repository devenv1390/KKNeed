package com.example.kkneed.navigation.nav_graph

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.navigation.SCANNER_ROUTE
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
            AllScreen.ScanResult.route + "/{code}",
            arguments = listOf(
                navArgument("code") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            val code = it.arguments?.getString("code") ?: ""
            ScanResultScreen(navController, code)
        }
        composable(AllScreen.Comment.route) {
            CommentScreen(navController)
        }
        composable(AllScreen.Detail.route) {
            DetailScreen(navController)
        }
        composable(
            AllScreen.Compare.route + "/{code}",
            arguments = listOf(
                navArgument("code") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            val code = it.arguments?.getString("code") ?: ""
            CompareScreen(navController, code)
        }
        composable(AllScreen.ScanHistory.route) {
            ScanHistoryScreen(navController)
        }
        composable(AllScreen.Chose.route) {
            ChoseScreen(navController)
        }
        composable(AllScreen.Edit.route) {
            EditScreen(navController)
        }
        composable(AllScreen.EditProduct.route) {
            EditProductScreen(navController)
        }
        composable(
            AllScreen.SCLoading.route + "/{code}",
            arguments = listOf(
                navArgument("code") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ){
            val code = it.arguments?.getString("code") ?: ""
            ScanLoadingScreen(navController,code)
        }
    }
}