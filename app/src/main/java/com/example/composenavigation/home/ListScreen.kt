package com.example.composenavigation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composenavigation.navigation.Screen
import com.example.composenavigation.ui.theme.ComposeNavigationTheme

@Composable
fun ListScreen(
    navController: NavController,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.clickable {
//                navController.navigate(Screen.Home.route) // bu şekilde yaparsak, screen'ler stack'te birikir, Home'a geri dönmek istiyorsak ve home'dan geldiysek kısacak popBackStack() komutunu kullanabiliriz.
//                navController.popBackStack()
                /**
                 * Peki hem popup yapmak, hem de parametre göndermek istiyorsak ne yapacağız?
                 */
                navController.navigate(Screen.Home.route){
                    popUpTo(Screen.Home.route){
                        inclusive = true // bu şekilde detail screen'den home screen'e eri dönebileecğiz. ve detail screen back stack'ten pop olacak.
                    }
                }
            },
            text = "List",
            color = Color.Green,
            fontSize = MaterialTheme.typography.displaySmall.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    ComposeNavigationTheme {
        ListScreen(
            rememberNavController()
        )
    }
}