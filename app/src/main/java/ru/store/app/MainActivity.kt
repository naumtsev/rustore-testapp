package ru.store.app

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ru.store.app.ui.theme.RuStoreAppTheme
import ru.store.app.views.appdetails.AppDetailsScreen
import ru.store.app.views.applist.AppListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RuStoreAppTheme {
                AppScreen()
            }
        }
    }
}

@Composable
fun AppScreen() {
    val navController = rememberNavController()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "app_list",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("app_list") {
                AppListScreen(onAppClick = { appName ->
                    val encodedAppName = Uri.encode(appName)
                    navController.navigate("app_details/$encodedAppName")
                })
            }

            composable(
                route = "app_details/{appName}",
                arguments = listOf(navArgument("appName") { type = NavType.StringType })
            ) { backStackEntry ->
                val appName = backStackEntry.arguments?.getString("appName") ?: ""

                AppDetailsScreen(
                    modifier = Modifier,
                    appId = appName,
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppScreenPreview() {
    RuStoreAppTheme {
        AppScreen()
    }
}