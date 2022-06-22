package com.example.demo1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.demo1.R
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

    Column(modifier = Modifier.fillMaxSize().padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        GenerarIcono()
    }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        //GenerarIcono()
        Text("MENU PRINCIPAL")
        Button(
            onClick = {
            navController.navigate(route = AppScreens.ListadoActivity.route)
        }
        ) {
            Text("Listado")
        }
    }
}

@Composable
fun GenerarIcono(){
    Image(painterResource(
        R.drawable.pokedex_icon),
        contentDescription = "App Icon",
        modifier = Modifier.size(175.dp)
        )
}

/*
@Preview(showBackground = true)
@Composable
fun TestoPreview(){
    MenuPrincipal()
}
*/