package donad.vn.kotlin

import Hi

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.ExperimentalFoundationApi

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Surface

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview

import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import donad.vn.kotlin.ASM.Cart
import donad.vn.kotlin.ASM.Congrats
import donad.vn.kotlin.ASM.Home
import donad.vn.kotlin.ASM.Login
import donad.vn.kotlin.ASM.Pay
import donad.vn.kotlin.ASM.Prouduct
import donad.vn.kotlin.ASM.Register
//import donad.vn.kotlin.test.HomeBV
//import donad.vn.kotlin.test.HomeTest
//import donad.vn.kotlin.test.LoginTest
//import donad.vn.kotlin.test.RegisterBV
//import donad.vn.kotlin.test.RegisterTest
import donad.vn.kotlin.ui.theme.KotlinTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Test()
                }
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun Test() {
        val navController = rememberNavController()
        NavHost(navController, startDestination = "Login") {
//            composable("Login01") { Login01(navController) }
//            composable(
//                "Login02/{phonenumber}",
//                arguments = listOf(navArgument("phonenumber") { type = NavType.StringType })
//            ) { NavBackStackEntry ->
//                Login02(
//                    navController,
//                    phonenumber = NavBackStackEntry.arguments?.getString("phonenumber")
//                )
//            }

            //asm
            composable("Home") { Home(navController) }
            composable("Cart") { Cart(navController) }
            composable("Pay") { Pay(navController) }
            composable("Congrats") { Congrats(navController) }
            composable("Login") { Login(navController) }
            composable("Register") { Register(navController) }
            composable(
                "Product/{_id}",
                arguments = listOf(
                    navArgument("_id") { type = NavType.StringType },
                ),
            ) { navBackStackEntry ->
                Prouduct(
                    navController = navController,
                    _id = navBackStackEntry.arguments?.getString("_id").toString()
                )
            }

            composable("Hi") { Hi(navController) }
        }
    }
}


