package com.example.demo1.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.demo1.navigation.AppScreens

@Composable
fun MenuPrincipal(navController: NavController){
    Scaffold(topBar={
        TopAppBar() {
            Text(text = "* MENU PRINCIPAL *")
        }
    }) {
        TestContent(navController)
    }
}

@Composable
fun TestContent(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("MENU PRINCIPAL")
        Button(onClick = {
            navController.navigate(route = AppScreens.ListadoActivity.route)
        }) {
            Text("Listado")
        }

    }
}


/*
@Preview(showBackground = true)
@Composable
fun TestoPreview(){
    MenuPrincipal()
}
*/