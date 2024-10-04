package com.example.natureapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.natureapp.ui.theme.NatureAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NatureAppTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Initial()
//        Cell()
//        Cell()
    }
}

class CellData(var titulo: String, var descripcion: String, var descripcionImagen: String, var idRecurso: Int)

@Composable
fun Initial() {
    val itemList = listOf(
        CellData(
            "Montañas Rocosas",
            "Una cordillera impresionante que se extiende a lo largo de América del Norte.",
            "Imagen de unas montañas.",
            R.drawable.mountains,
        ),
        CellData(
            "Gran Barrera de Coral",
            "Una cordillera impresionante que se extiende a lo largo de América del Norte.",
            "Imagen de unas montañas.",
            R.drawable.barrera_coral,
        ),
        CellData(
            "Desierto del Sahara",
            "El desierto más grande del mundo, conocido por sus vastas dunas de arena.",
            "Imagen del desierto del Sahara.",
            R.drawable.desierto,
        ),
        CellData(
            "Bosque Frondoso",
            "Un bosque perfecto para caminatas y dias de campamento.",
            "Imagen de un bosque.",
            R.drawable.bosque,
        ),
        CellData(
            "Playa",
            "Un calido paracio en para pasar el rato con tu familia.",
            "Imagen del oceano.",
            R.drawable.oceano,
        ),
    )
    LazyColumn (
        modifier = Modifier
            .padding(10.dp)
    ) {
        items(itemList.count()) { item ->
            Cell(
                itemList[item].idRecurso,
                itemList[item].titulo,
                itemList[item].descripcion,
                itemList[item].descripcionImagen,
            )
        }
    }
//    Column(
//        modifier = Modifier
//            .padding(10.dp)
//    ) {
//        Cell(R.drawable.mountains)
//        Cell(R.drawable.barrera_coral)
//        Cell(R.drawable.desierto)
//        Cell(R.drawable.bosque)
//    }
}

@Composable
fun Cell(id: Int, titulo: String, descripcion: String, descripcionImagen: String) {
    Box(
        modifier = Modifier
            .padding(bottom = 20.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xffd4d4dc))
        ) {
            Column {
                Image(
                    painter = painterResource(id = id),
                    contentDescription = descripcionImagen
                )
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Text(
                        text = titulo,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = descripcion,
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NatureAppTheme {
        Greeting("Android")
    }
}