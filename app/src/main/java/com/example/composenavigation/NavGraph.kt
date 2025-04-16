package com.example.composenavigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument


@Composable
fun SetupNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        // Bu body'de NavGraphBuilder'da olmasını istediğimiz tüm ekranları ekleyeceğiz.
        composable(route = Screen.Home.route) {
            HomeScreen(navController)
        }

        composable(
            route = Screen.Detail.route, arguments = listOf(
                navArgument(DETAIL_ARGUMENT_KEY) {
                    type = NavType.IntType
                },
                navArgument(DETAIL_ARGUMENT_KEY2) {
                    type = NavType.StringType
                })
        ) {
            Log.d("Args", it.arguments?.getInt(DETAIL_ARGUMENT_KEY).toString())
            Log.d("Args", it.arguments?.getString(DETAIL_ARGUMENT_KEY2).toString())
            DetailScreen(navController = navController)
        }

        composable(
            route = Screen.List.route, arguments = listOf(
                navArgument(LIST_ARGUMENT_KEY) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(LIST_ARGUMENT_KEY2) {
                    type = NavType.StringType
                    defaultValue = "default_name"
                    nullable = true
                }
            )) {
            Log.d("Args", it.arguments?.getInt(LIST_ARGUMENT_KEY).toString())
            Log.d("Args", it.arguments?.getString(LIST_ARGUMENT_KEY2).toString())
            ListScreen(navController = navController)
        }
    }
}