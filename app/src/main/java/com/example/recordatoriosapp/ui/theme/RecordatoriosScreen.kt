package com.example.recordatoriosapp.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recordatoriosapp.data.RecordatorioRepository
import com.example.recordatoriosapp.model.Recordatorio
import com.example.recordatoriosapp.model.Estado
import com.example.recordatoriosapp.model.Prioridad

@Composable
fun RecordatoriosScreen() {

    val recordatorios = RecordatorioRepository.recordatorios

    val pendientes = RecordatorioRepository
        .filtrarPorEstado(Estado.Pendiente)

    val prioridadAlta = RecordatorioRepository
        .filtrarPorPrioridad(Prioridad.Alta)

    Scaffold { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            Text(
                text = "Mis Recordatorios",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Total: ${recordatorios.size}"
            )

            Text(
                text = "Pendientes: ${pendientes.size} | Alta prioridad: ${prioridadAlta.size}"
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(
                    items = recordatorios,
                    key = { it.id }
                ) { recordatorio ->

                    RecordatorioCard(recordatorio)
                }
            }
        }
    }
}

@Composable
fun RecordatorioCard(recordatorio: Recordatorio) {

    val colorCategoria =
        RecordatorioRepository.obtenerColorCategoria(
            recordatorio.categoria
        )

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {

            Text(
                text = recordatorio.titulo,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = "Categoría: ${recordatorio.categoria.nombre}",
                color = colorCategoria
            )

            Text(
                text = "Prioridad: ${recordatorio.prioridad.nombre}"
            )

            Text(
                text = "Estado: ${recordatorio.estado.nombre}"
            )

            recordatorio.descripcion?.let {
                Text(text = it)
            }

            recordatorio.ubicacion?.let {
                Text(text = "Ubicación: $it")
            }

            recordatorio.aviso?.let {
                Text(text = "Aviso: $it")
            }
        }
    }
}
