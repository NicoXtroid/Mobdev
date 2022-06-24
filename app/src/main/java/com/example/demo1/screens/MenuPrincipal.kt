package com.example.demo1.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        GenerarIcono()
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 60.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = {
            navController.navigate(route = AppScreens.ListadoActivity.route)
        }
        ) {
            Text("Pokedex\nNacional", fontSize = 30.sp)
        }
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = {
                //GenerarMensaje(texto = "Boton en Construccionj")
            navController.navigate(route = AppScreens.ListadoActivity.route)
            }
        ) {
            Text("Team\nBuilder", fontSize = 30.sp)
        }
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = {
                //
            }
        ) {
            Text("Información", fontSize = 30.sp)
        }
    }
}
@Composable
fun GenerarMensaje(texto: String){
    val contexto = LocalContext.current
    val openDialog = remember { mutableStateOf(true)}
    
    if(openDialog.value){
        AlertDialog(
            onDismissRequest = { openDialog.value = false},
            title = { Text(text = "Informacion!")},
            text = { Text(text = texto)},

            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        Toast.makeText(contexto, "Confirm Button Click", Toast.LENGTH_SHORT).show()
                    }) {
                        Text(text = "Ok!")
                }
            },
            backgroundColor = Color.Magenta,
            contentColor = Color.Black
                
        )
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