package com.example.composenavigation.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.composenavigation.auth.LoginScreen
import com.example.composenavigation.auth.SignUpScreen
import com.example.composenavigation.navigation.AUTHENTICATION_ROUTE
import com.example.composenavigation.navigation.Screen


fun NavGraphBuilder.authNavGraph(
    navController: NavHostController,
) {
    navigation(
        startDestination = Screen.Login.route,
        route = AUTHENTICATION_ROUTE
    ) {
        composable(route = Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(route = Screen.SignUp.route) {
            SignUpScreen(navController)
        }
    }
}