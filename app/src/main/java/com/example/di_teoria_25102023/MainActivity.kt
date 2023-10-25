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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
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
        EjemploCardAvanzado(imagen = R.drawable.gato1, texto1 = "Gato 1", texto2 = "Gato 2")
        EjemploCardAvanzado(imagen = R.drawable.gato2, texto1 = "Gato 1", texto2 = "Gato 2")
        EjemploCardAvanzado(imagen = R.drawable.gato3, texto1 = "Gato 1", texto2 = "Gato 2")
    }
}

//Badge box: iconos con un numerito, como los de nueva notificación
//COmo es experimental, hay que ponerle la siguiente anotación para que funcione
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploBadgeBox() {
    BadgedBox(badge = { Text(text = "1") }, modifier = Modifier.padding(16.dp)) {
        Icon(imageVector = Icons.Default.Star, contentDescription = null)
    }
}

//EJEMPLO DE CONTADOR NUMÉRICO PARA UN BADGEBOX
@Composable
fun BadgeContenido(count: Int) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .background(color = Color.Red, shape = CircleShape)
            .padding(4.dp)
    ) {
        Text(
            text = count.toString(),
            style = MaterialTheme.typography.bodySmall.copy(
                color = MaterialTheme.colorScheme.onPrimary
            ),
            modifier = Modifier.padding(4.dp)
        )
    }

}

//IMPLEMTNACIÖN DE BADGED + NUMERITO CON ESTILO
@Composable
fun EjemploBadgeBoxConNumeroEstilo() {
    var badgeCount by rememberSaveable {
        mutableStateOf(1)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

    }
    @OptIn(ExperimentalMaterial3Api::class)
    BadgedBox(badge = {
        BadgeCount(count = badgeCount), modifier = Modifier.padding(16.dp)) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Star, contentDescription = null, modifier = Modifier
                    .size(40.dp)
            )
        }
    }
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = badgeCount.toString(), onValueChange = {
            badgeCount = it.toIntOrNull() ?: 0
        })
    }
}


//Divider- > separador, es una línea separadora
@Composable
fun EjemploDivider() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Texto 1")
        Divider(//para una línea horizontal
            Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 20.dp), color = Color.Red
        )
        Text(text = "Texto 2")
    }
}

//DropdownMenu-> menú desplegable
@Preview(showBackground = true)
@Composable
fun EjemploDropDownMenu() {
    var selectedText by rememberSaveable {
        mutableStateOf("..")
    }
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }

    val guitarras = listOf("Fender", "Gibson", "Yamaha", "Ibanez")
    Column(modifier = Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            guitarras.forEach { guitarra ->
                DropdownMenuItem(
                    text = { Text(text = guitarra) },
                    onClick = {
                        expanded = false
                        selectedText = guitarra
                    }
                )
            }
        }
    }
}








































