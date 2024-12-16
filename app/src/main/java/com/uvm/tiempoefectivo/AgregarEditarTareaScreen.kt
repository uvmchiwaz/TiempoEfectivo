package com.uvm.tiempoefectivo

import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.uvm.tiempoefectivo.ui.theme.TiempoEfectivoTheme // Asegúrate de que la ruta sea correcta

@Composable
fun AgregarEditarTareaScreen(navController: NavController) {
    var descripcion by remember { mutableStateOf("") }
    var fechaLimite by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            label = { Text("Descripción") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = fechaLimite,
            onValueChange = { fechaLimite = it },
            label = { Text("Fecha límite") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(onClick = {
                // TODO: Guardar tarea
            }) {
                Text("Guardar")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = {
                navController.navigate("principal")
            }) {
                Text("Cancelar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AgregarEditarTareaScreenPreview() {
    TiempoEfectivoTheme {
        AgregarEditarTareaScreen(navController = rememberNavController())
    }
}