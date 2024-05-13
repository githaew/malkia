package com.example.malkia.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.malkia.ui.theme.screen.about.HomeScreen
import com.example.malkia.ui.theme.screen.login.LoginScreen
import com.example.malkia.ui.theme.screen.logout.LogoutScreen


@Composable
fun AppNavHost(modifier: Modifier = Modifier,
               navController : NavHostController = rememberNavController(),
               startDestination: String=ROUTE_REGISTER){
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ){
        
        composable(ROUTE_REGISTER) {
            RegisterScreen(navController)
        }
        composable(ROUTE_ABOUT) {
            AboutScreen(navController)
        }
        composable(ROUTE_LOGOUT) {
            LogoutScreen(navController)
        }
        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }
        composable(ROUTE_VIEW_UPLOAD){
            ViewUploadScreen(navController)
        }
        composable(ROUTE_ADD_PRODUCT){
            AddProductsScreen(navController)
        }
        composable(ROUTE_UPDATE_PRODUCT+"/{id}"){
            UpdateProductsScreen(
                navController,passedData.arguments?.getString("id")!!
            )
        }
        composable(ROUTE_VIEW_PRODUCT){
            ViewProductsScreen(navController)
        }
    }
}