package com.example.di_teoria_25102023

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.di_teoria_25102023.ui.theme.Di_teoria_25102023Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Di_teoria_25102023Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

//CARD - > CONTENEDOR DE TARJETAS

@Composable
fun EjemploCard() {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),//elevation es el relieve
        shape = RoundedCornerShape(10.dp),//redondeo de esquinas
        colors = CardDefaults.cardColors(//colores
            containerColor = Color.LightGray,
            contentColor = Color.Red
        ),
        border = BorderStroke(5.dp, Color.Green)//color del borde
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(text = "Texto 1")
            Text(text = "Texto 2")
        }
    }
}



//CARDS AVANZADAS
@Composable
fun EjemploCardAvanzado(imagen: Int, texto1: String, texto2: String) {
    Card(modifier = Modifier
        .padding(8.dp)
        .clickable { }
        .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = imagen),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = texto1,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
                Text(
                    text = texto2,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box() {
                        Row {
                            TextButton(onClick = {}) {
                                Text(text = "Gatos")
                            }
                            TextButton(onClick = {}) {
                                Text(text = "Razas")
                            }
                        }
                    }

                    Box() {
                        Row {
                            IconButton(onClick = {}) {
                                Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
                            }
                            IconButton(onClick = {}) {
                                Icon(imageVector = Icons.Filled.Search, contentDescription = null)
                            }
                        }

                    }
                }
            }
        }
    }

}



//LANZADOR DE CARDS AVANZADAS
@Composable
fun TarjetasDeGatos() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {


    }

}












































