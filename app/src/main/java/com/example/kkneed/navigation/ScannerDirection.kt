package com.example.kkneed.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument

class ScannerDirection {
    data class ScannerComposeArgs(
        val code:String,
        val codeType:String
    )

    companion object{
        val route = "scan_result_screen?code={code},codeType={type}"
        val argumentsList:MutableList<NamedNavArgument>
            get() = mutableListOf(
                navArgument("code"){
                    type = NavType.StringType
                    defaultValue = "null"

                },
                navArgument("codeType"){
                    type = NavType.StringType
                    defaultValue = "BC"
                }
            )
        fun parseArguments(backStackEntry: NavBackStackEntry):ScannerComposeArgs{
            return ScannerComposeArgs(
                code = backStackEntry.arguments?.getString("code")?:"",
                codeType = backStackEntry.arguments?.getString("codeType")?:"BC",
            )
        }
        fun actionMaintoNew(code: String,codeType: String):String{
            return "scan_result_screen?code=$code,codeType=$codeType"
        }
    }

}