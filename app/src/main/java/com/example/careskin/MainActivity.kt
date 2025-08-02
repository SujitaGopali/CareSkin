package com.example.careskin
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.careskin.ui.theme.CartScreen
import com.example.careskin.ui.theme.HomeScreen
import com.example.careskin.ui.theme.LoginScreen
import com.example.careskin.ui.theme.OrderScreen
import com.example.careskin.ui.theme.RegisterScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Use the MaterialTheme provided by the default template
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ) {
                        composable("login") {
                            LoginScreen(navController)
                        }
                        composable("register") {
                            RegisterScreen(navController)
                        }
                        composable("home") {
                            HomeScreen(navController)
                        }
                        composable("cart") {
                            CartScreen(navController)
                        }
                        composable("order") {
                            OrderScreen(navController)
                        }
                    }
                }
            }
        }
    }
}
