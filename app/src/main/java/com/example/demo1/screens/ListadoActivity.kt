package com.example.demo1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.demo1.classes.Pokemon


@Composable
fun ListadoActivity(navController: NavController){
    Scaffold (topBar = {
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Flecha Volver",
                modifier = Modifier.clickable {
                    navController.popBackStack()
                }
            )
            Text(text = "* LISTADO COMPLETO *")
        }
    }){
        ListadoBody(navController)
    }
}

@Composable
fun ListadoBody(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Pokedex")
        GenerarListado()
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text( "VOLVER")
        }
    }
}

fun DeterminarColor(tipoE: String) : Color{
    var colorTipo: Color = Color.White
    when(tipoE){
         "Normal" -> {
             colorTipo = Color.LightGray
         }
        "Planta" -> {
            colorTipo = Color.Green
        }
        "Fuego" -> {
            colorTipo = Color.Red
        }

     }
    return colorTipo

}

val Bulbasaur = Pokemon(1,"Bulbasaur","Planta","Veneno","Carga la semilla de una planta en su espalda desde el nacimiento, la semilla se desarrolla lentamente. Los investigadores no saben si calificarlo como una planta o animal. Es extremadamente feroz y muy difícil de capturar en el bosque.")
val Ivysaur = Pokemon(2, "IvySaur","Planta","Veneno","Forma evolucionada del Bulbasaur. Cuanto más fuerte sea la luz solar que absorbe, más fuerte será este Pokémon, y más grande será la flor que salga de su capullo.")
val Charmander = Pokemon(4,"Charmander", "Fuego", null, "El Pokemon Lagarto. Una flama arde en la punta de su cola desde su nacimiento. Se dice que el Charmander muere si su flama llega a apagarse.")

@Composable
fun GenerarListado(){
    GenerarBloque(poke = Bulbasaur)
    GenerarBloque(poke = Ivysaur)
    GenerarBloque(poke = Charmander)
}

@Composable
fun GenerarBloque(poke: Pokemon){
    Row(modifier = Modifier.padding(8.dp)) {
        DesglosarData(poke = poke)
    }
}
@Composable
fun DesglosarData(poke: Pokemon){
    val numero = poke.numero
    var type2 = poke.tipo2
    if (type2 == null){
        type2=""
    }else{
        type2= "/" + type2
    }
    Column(modifier = Modifier.background(
        color = DeterminarColor(poke.tipo1)
        )
    ){
        Text(text = "#$numero ${poke.nombre} Tipo: ${poke.tipo1}$type2", style = MaterialTheme.typography.subtitle1)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "${poke.descripcion}", style = MaterialTheme.typography.subtitle2)
    }
}

/*
@Preview(showBackground = true)
@Composable
fun ListadoDefaultPreview(){
    ListadoActivity()}
*/