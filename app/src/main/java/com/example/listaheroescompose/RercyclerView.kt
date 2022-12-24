package com.example.listaheroescompose

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listaheroescompose.model.Superhero

/****
 * Project: ListaHeroesCompose
 * From: com.example.listaheroescompose
 * Created by: Victor Sanjines Lopez on 12/12/2022 at 19:31
 * More info: www.relativity.com.bo
 * All rights reserved 2022
 ****/

@Composable
fun SimpleRecyclerView() {
    val myList = listOf("Victor", "Jaime", "Anthony", "Paola", "Leandro", "Yamir", "Alfredo")
    LazyColumn {
        //Cada elemento de la lista es un item
        item { Text(text = "Cabecera primer item") }
        items(7) {
            Text(text = "Este es el item $it")
        }
        items(myList) {
            Text(text = "Hola me llamo $it")
        }
        item { Text(text = "Footer primer item") }
    }
}

@Composable
fun SuperheroView() {
    val context = LocalContext.current
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperheroes()) { superhero ->
            ItemSuperhero(superhero = superhero) {
                Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

/*
 Desarrollar la logica para dibujar cada item de nuestra lista
 */
@Composable
fun ItemSuperhero(superhero: Superhero, onItemSelected: (Superhero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Blue),
        modifier = Modifier
            .width(500.dp)
            .clickable { onItemSelected(superhero) }) {
        Column {
            Image(
                painter = painterResource(id = superhero.photo),
                contentDescription = "Superhero Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superhero.name,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superhero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superhero.publisher,
                modifier = Modifier.align(Alignment.End),
                fontSize = 10.sp
            )
        }
    }
}

fun getSuperheroes(): List<Superhero> = listOf(
    Superhero("Spiderman", "Petter Parker", "Marvel", R.drawable.spiderman),
    Superhero("Wolverine", "Logan", "Marvel", R.drawable.logan),
    Superhero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
    Superhero("Flash", "Jay Garrick", "DC", R.drawable.flash),
    Superhero("Thor", "Thor Odinson", "Marvel", R.drawable.thor),
    Superhero("Wonder Woman", "Diana Prince", "DC", R.drawable.wonder_woman),
)

























