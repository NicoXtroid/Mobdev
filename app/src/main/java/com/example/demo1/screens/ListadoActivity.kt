package com.example.demo1.screens

import android.graphics.drawable.Drawable
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.demo1.R


@Composable
fun ListadoActivity(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Flecha Volver",
                modifier = Modifier.clickable {
                    navController.popBackStack()
                }
            )
            Text(text = "* LISTADO COMPLETO *")
        }
    }) {
        ListadoBody(navController)
    }
}

@Composable
fun ListadoBody(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Pokedex")
        GenerarListado(listadoPoke)
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("VOLVER")
        }
    }
}

@Composable
fun GenerarImagen(num: Int) {
    when (num) {
        1 ->{Image(
            painterResource(R.drawable.pokemon_1),
            "POkemon Imagen",
            modifier = Modifier.size(64.dp)
        ) }
        2 ->{Image(
            painterResource(R.drawable.pokemon_2),
            "POkemon Imagen",
            modifier = Modifier.size(64.dp)
        ) }
        else -> {Image(
            painterResource(R.drawable.ic_launcher_foreground),
            "POkemon Imagen",
            modifier = Modifier.size(64.dp)
        )}

    }

}

fun DeterminarColor(tipoE: String): Color {
    var colorTipo: Color = Color.White
    when (tipoE) {
        "Normal" -> {
            colorTipo = Color.LightGray
        }
        "Planta" -> {
            colorTipo = Color.Green
        }
        "Fuego" -> {
            colorTipo = Color.Red
        }
        "Agua" -> {
            colorTipo = Color.Cyan
        }

    }
    return colorTipo

}

val Bulbasaur = Pokemon(
    1,
    "Bulbasaur",
    "Planta",
    "Veneno",
    "Carga la semilla de una planta en su espalda desde el nacimiento, la semilla se desarrolla lentamente. Los investigadores no saben si calificarlo como una planta o animal. Es extremadamente feroz y muy difícil de capturar en el bosque."
)
val Ivysaur = Pokemon(
    2,
    "IvySaur",
    "Planta",
    "Veneno",
    "Forma evolucionada del Bulbasaur. Cuanto más fuerte sea la luz solar que absorbe, más fuerte será este Pokémon, y más grande será la flor que salga de su capullo."
)
val Charmander = Pokemon(
    4,
    "Charmander",
    "Fuego",
    null,
    "El Pokemon Lagarto. Una flama arde en la punta de su cola desde su nacimiento. Se dice que el Charmander muere si su flama llega a apagarse."
)
val Totodile = Pokemon(
    158,
    "Tododile",
    "Agua",
    null,
    "El Pokemon mandíbula. Su Mandíbula sumamente desarrollada es tan poderosa que puede triturar cualquier cosa. Atencion entrenadores: a este pokémon le gusta usar sus dientes."

)
val listadoPoke : ArrayList<Pokemon> = arrayListOf<Pokemon>(Bulbasaur, Ivysaur, Charmander, Totodile)


@Composable
fun GenerarListado(listado : ArrayList<Pokemon>) {
    val scrollState = rememberScrollState()
    var sw= 0
    Column(modifier = Modifier.verticalScroll(scrollState)) {
        listado.forEach {
            val numero = it.numero

            when (numero){

                in 1..151 -> {
                    if (sw == 0){
                        Text("Pokedex Kanto")
                        sw += 1
                    }
                    Row(modifier = Modifier.padding(8.dp)) {
                        GenerarPokemon(poke = it)
                    }
                    sw = 1
                }
                152 -> {
                    Text("Pokedex Johto")
                }
                in 152..251 ->{

                    Row(modifier = Modifier.padding(8.dp)) {
                        GenerarPokemon(poke = it)
                    }

                }

            }
        }
    }
}

@Composable
fun GenerarPokemon(poke: Pokemon) {
    val numero = poke.numero

    Row(modifier = Modifier.padding(8.dp)) {
        GenerarImagen(poke.numero)
        PokemonEntry(poke = poke)
    }
}

@Composable
fun PokemonEntry(poke: Pokemon) {
    val numero = poke.numero
    var type2 = poke.tipo2
    if (type2 == null) {
        type2 = ""
    } else {
        type2 = "/" + type2
    }
    var expand by remember { mutableStateOf(false) }

    Column(
        //modifier = Modifier.background(color = DeterminarColor(poke.tipo1)
        modifier = Modifier
            .clickable {
                expand = !expand
            }
            .background(color = DeterminarColor(poke.tipo1))
    )
    {
        GenerarTexto(
            txt = "#$numero ${poke.nombre} Tipo: ${poke.tipo1}$type2",
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(10.dp))
        GenerarTexto(
            txt = "${poke.descripcion}",
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.subtitle2,
            if(expand) Int.MAX_VALUE else 1
        )
    }
}

@Composable
fun GenerarTexto(txt: String, color: Color, style: TextStyle, lines: Int = Int.MAX_VALUE) {
    Text(txt, color = color, style = style, maxLines = lines)
}
/*
@Preview(showBackground = true)
@Composable
fun ListadoDefaultPreview(){
    ListadoActivity()}
*/