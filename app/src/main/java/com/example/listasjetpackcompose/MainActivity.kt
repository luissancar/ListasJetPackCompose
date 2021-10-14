package com.example.listasjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listasjetpackcompose.modelos.Productos
import com.example.listasjetpackcompose.modelos.Publicidad
import com.example.listasjetpackcompose.ui.theme.ListasJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListasJetPackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting()
                }
            }
        }
    }
}

val listaProductos = listOf(
    Productos("cosa 01", 23),
    Productos("cosa 02", 233),
    Productos("cosa 03", 223),
    Productos("cosa 04", 238),
    Productos("cosa 05", 23),
    Productos("cosa 06", 233),
    Productos("cosa 07", 223),
    Productos("cosa 08", 238),
    Productos("cosa 09", 23),
    Productos("cosa 10", 233),
    Productos("cosa 11", 223),
    Productos("cosa 12", 238),
    Productos("cosa 13", 23),
    Productos("cosa 14", 233),
    Productos("cosa 15", 223),
    Productos("cosa 16", 238)
)
val listaPublicidad = listOf(
    Publicidad("publicidad01"),
    Publicidad("publicidad02"),
    Publicidad("publicidad03"),
    Publicidad("publicidad04"),
    Publicidad("publicidad05")
)

@Composable
fun Greeting() {
    LazyColumn(
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),

    )
    {
        item{
            Text(
                text = "Productos",
                style = TextStyle
                    (
                    color = Color.Red,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }

    /*    items(listaProductos){
            ProductoDiseño(producto = it)
        }*/

        itemsIndexed(listaProductos) { posicion, producto ->
            if (posicion == 3){
                LazyRow{
                    items(listaPublicidad){
                        PublicidadDiseño(publicidad = it)
                    }

                }
            }
            else {
                ProductoDiseño(producto = producto)
            }
        }
    }
}

@Composable
fun ProductoDiseño(producto: Productos) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = producto.nombre,
            style = TextStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold
            )

        )

        Text(
            text = "${producto.precio}.00 €",
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Light
            )

        )
    }}

    @Composable
    fun PublicidadDiseño(publicidad: Publicidad) {
        Box(
            modifier = Modifier
                .padding(end = 8.dp)
                .size(120.dp)
                .clip(RoundedCornerShape(12))
                .background(color = Color.Magenta)
                ,
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = publicidad.titulo,
                style = TextStyle(
                    fontSize = 25.sp,
                    fontWeight = FontWeight.SemiBold
                )

            )


        }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ListasJetPackComposeTheme {
        Greeting()
    }
}