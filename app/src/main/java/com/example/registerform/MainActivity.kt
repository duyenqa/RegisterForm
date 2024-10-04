package com.example.registerform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.registerform.ui.theme.RegisterFormTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RegisterFormTheme {
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
                                navController.navigate("screen_dashboard");
                            },
                            navigateBack = {
                            navController.popBackStack()
                        })
                    }
                    composable(route = "screen_dashboard") {
                        ScreenDashboard()
                    }
                }
            }
        }
    }
}