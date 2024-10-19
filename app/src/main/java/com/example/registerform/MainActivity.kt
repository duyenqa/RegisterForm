package com.example.registerform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.example.registerform.ui.theme.RegisterFormTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RegisterFormTheme {
                val imageId = arrayOf(
                    R.drawable.cat1,
                    R.drawable.cat2,
                    R.drawable.cat3,
                    R.drawable.cat4,
                    R.drawable.cat5,
                    R.drawable.cat6,
                    R.drawable.cat7,
                    R.drawable.cat8,
                    R.drawable.cat9,
                    R.drawable.cat10
                )

                val names = arrayOf(
                    "Dora",
                    "Levi",
                    "Sammy",
                    "Begals",
                    "Mango",
                    "Jojo",
                    "Diane",
                    "Marvin",
                    "Mesina",
                    "Hammy",
                )

                val description = arrayOf(
                    "Lorem Ipsum is simply dummy text",
                    "Lorem Ipsum is simply dummy text",
                    "Lorem Ipsum is simply dummy text",
                    "Lorem Ipsum is simply dummy text",
                    "Lorem Ipsum is simply dummy text",
                    "Lorem Ipsum is simply dummy text",
                    "Lorem Ipsum is simply dummy text",
                    "Lorem Ipsum is simply dummy text",
                    "Lorem Ipsum is simply dummy text",
                    "Lorem Ipsum is simply dummy text",
                )
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "screen_signup"){
                    composable(route = "screen_signup") {
                        ScreenSignup(navigateToB = {
                            navController.navigate("screen_login")
                        })
                    }
                    composable(route = "screen_login") {
                        ScreenLogin(
                            navigateToC={
                                navController.navigate("screen_dashboard")
                            },
                            navigateBack = {
                            navController.popBackStack()
                        })
                    }
                    composable(route = "screen_dashboard") {
                        ScreenDashboard(imageId, names, description, navController)
                    }
                    composable(
                        route = "screen_detail/{index}",
                        arguments = listOf(
                            navArgument(name = "index") {
                                type = NavType.IntType
                            }
                        )
                    ) { backStackEntry ->
                        ScreenDetail(
                            imageId = imageId,
                            names = names,
                            description = description,
                            itemIndex = backStackEntry.arguments?.getInt("index")
                        )
                    }
                }
            }
        }
    }
}