package com.example.malkia.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.malkia.ui.theme.screen.about.HomeContent
import com.example.malkia.ui.theme.screen.login.LoginScreen
import com.example.malkia.ui.theme.screen.logout.LogoutScreen
import com.example.malkia.ui.theme.screen.products.AddProductsScreen
import com.example.malkia.ui.theme.screen.products.UpdateProductsScreen
import com.example.malkia.ui.theme.screen.products.ViewProductsScreen
import com.example.malkia.ui.theme.screen.products.ViewUploadsScreen
import com.example.malkia.ui.theme.screen.registration.RegisterScreen



@Composable
fun AppNavHost(modifier: Modifier = Modifier,
               navController : NavHostController = rememberNavController(),
               startDestination: String= ROUTE_ABOUT_SCREEN){
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ){

        composable(ROUTE_ABOUT_SCREEN) {
            HomeContent(navController)
        }
        composable(ROUTE_REGISTER_SCREEN) {
            RegisterScreen(navController)
        }
        composable(route = ROUTE_LOGIN_SCREEN) {
            LoginScreen(navController)
        }
        composable(ROUTE_LOGOUT) {
            LogoutScreen(navController)
        }
        composable(ROUTE_VIEW_UPLOAD){
            ViewUploadsScreen(navController)
        }
        composable(ROUTE_ADD_PRODUCT){
            AddProductsScreen(navController)
        }
        composable(ROUTE_UPDATE_PRODUCT+ "/{id}"){passedData ->
            UpdateProductsScreen(navController,passedData.arguments?.getString("id")!!)
        }
//        composable(ROUTE_UPDATE_PRODUCT){
//            UpdateProductsScreen(navController)
//        }
        composable(ROUTE_VIEW_PRODUCT){
            ViewProductsScreen(navController)
        }
    }
}


