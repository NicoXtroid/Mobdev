package com.example.demo1.navigation

import androidx.compose.runtime.Composable

sealed class AppScreens(val route: String){
    object MenuPrincipal: AppScreens("menu_principal")
    object ListadoActivity: AppScreens("listado_activity")
}

