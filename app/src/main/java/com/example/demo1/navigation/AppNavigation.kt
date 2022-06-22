package com.example.demo1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.demo1.screens.ListadoActivity
import com.example.demo1.screens.MenuPrincipal

@Composable
fun AppNavigation(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.MenuPrincipal.route){
        composable(route= AppScreens.MenuPrincipal.route){
            MenuPrincipal(navController)
        }
        composable(route= AppScreens.ListadoActivity.route){
            ListadoActivity(navController)
        }
    }

}