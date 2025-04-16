package com.example.composenavigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composenavigation.ui.theme.ComposeNavigationTheme

@Composable
fun HomeScreen(
    navController: NavController,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.clickable {
//                navController.navigate(route = Screen.Detail.route)
                navController.navigate(route = Screen.Detail.passIdAndName(23, "Mustafa"))
            },
            text = "Home",
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.displaySmall.fontSize,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            modifier = Modifier.clickable {
//                navController.navigate(route = Screen.Detail.route)
                navController.navigate(route = Screen.List.passId(51))
            },
            text = "Go to ListScreen with one optional parameter",
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.displaySmall.fontSize,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            modifier = Modifier.clickable {
//                navController.navigate(route = Screen.Detail.route)
                navController.navigate(route = Screen.List.passIdAndName(25,"Mustafa"))
            },
            text = "Go to ListScreen with multiple optional parameters",
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.displaySmall.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ComposeNavigationTheme {
        HomeScreen(
            navController = rememberNavController()
        )
    }
}