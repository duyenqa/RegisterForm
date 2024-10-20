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
                    "Mèo Munchkin Màu Bicolor",
                    "Mèo Munchkin Màu Silver",
                    "Mèo Anh Lông Ngắn Màu Bicolor",
                    "Mèo Anh Lông Ngắn Màu Classic",
                    "Mango",
                    "Mèo Munchkin Chân Ngắn Màu Classic Tabby",
                    "Mèo Đen",
                    "Mèo Anh Lông Ngắn Màu Classic - ALN066",
                    "Mèo Anh lông ngắn màu Classic Tabby - ALN06179",
                    "Mèo Anh Lông Ngắn Màu Bicolor - ALN02175",
                )

                val description = arrayOf(
                    "Bé mèo đực/cái có mặt tròn rất lanh lợi, với nhiều vân tabby trên người cân đối, đặc màu Bicolor thuộc màu hiếm gặp trên thị trường mèo Việt Nam. Độ tuổi 15 tháng",
                    "Bé mèo đực/cái có mặt tròn rất lanh lợi, với nhiều vân tabby trên người cân đối, đặc màu Silver thuộc màu hiếm gặp trên thị trường mèo Việt Nam. Độ tuổi 7 tháng",
                    "Bé mèo đực/cái có mặt tròn rất lanh lợi, với nhiều vân tabby trên người cân đối, đặc màu Bicolor thuộc màu hiếm gặp trên thị trường mèo Việt Nam. Độ tuổi 10 tháng",
                    "Bé mèo đực/cái có mặt tròn rất lanh lợi, với nhiều vân tabby trên người cân đối, đặc màu Classic thuộc màu hiếm gặp trên thị trường mèo Việt Nam. Độ tuổi 4 tháng",
                    "Bé mèo đực/cái có mặt tròn rất lanh lợi, với nhiều vân tabby trên người cân đối, thuộc màu hiếm gặp trên thị trường mèo Việt Nam. Độ tuổi 15 tháng",
                    "Bé mèo đực/cái có mặt tròn rất lanh lợi, với nhiều vân tabby trên người cân đối, đặc màu Classic Tabby thuộc màu hiếm gặp trên thị trường mèo Việt Nam. Độ tuổi 20 tháng",
                    "Bé mèo đực/cái có mặt tròn rất lanh lợi, với nhiều vân tabby trên người cân đối, đặc màu Black, mèo Việt Nam. Độ tuổi 12 tháng",
                    "Bé mèo đực/cái có mặt tròn rất lanh lợi, với nhiều vân tabby trên người cân đối, đặc màu Classic thuộc màu hiếm gặp trên thị trường mèo Việt Nam. Độ tuổi 10 tháng",
                    "Bé mèo đực/cái có mặt tròn rất lanh lợi, với nhiều vân tabby trên người cân đối, đặc màu Classic Tabby thuộc màu hiếm gặp trên thị trường mèo Việt Nam. Độ tuổi 12 tháng",
                    "Bé mèo đực/cái có mặt tròn rất lanh lợi, với nhiều vân tabby trên người cân đối, đặc màu Bicolor thuộc màu hiếm gặp trên thị trường mèo Việt Nam. Độ tuổi 3 tháng",
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
                        ScreenDashboard(imageId, names, navController)
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