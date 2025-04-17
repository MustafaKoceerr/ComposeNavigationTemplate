package com.example.composenavigation.navigation.navgraph

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.composenavigation.home.DetailScreen
import com.example.composenavigation.home.HomeScreen
import com.example.composenavigation.home.ListScreen
import com.example.composenavigation.navigation.DETAIL_ARGUMENT_KEY
import com.example.composenavigation.navigation.DETAIL_ARGUMENT_KEY2
import com.example.composenavigation.navigation.HOME_ROUTE
import com.example.composenavigation.navigation.LIST_ARGUMENT_KEY
import com.example.composenavigation.navigation.LIST_ARGUMENT_KEY2
import com.example.composenavigation.navigation.Screen


fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController,
) {
    navigation(
        startDestination = Screen.Home.route,
        route= HOME_ROUTE
    ){
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
            ))
        {
            Log.d("Args", it.arguments?.getInt(LIST_ARGUMENT_KEY).toString())
            Log.d("Args", it.arguments?.getString(LIST_ARGUMENT_KEY2).toString())
            ListScreen(navController = navController)
        }
    }

}