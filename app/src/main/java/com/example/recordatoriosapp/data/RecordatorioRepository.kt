package com.example.recordatoriosapp.data
import androidx.compose.ui.graphics.Color
import com.example.recordatoriosapp.model.Categoria
import com.example.recordatoriosapp.model.Estado
import com.example.recordatoriosapp.model.Prioridad
import com.example.recordatoriosapp.model.Recordatorio

object RecordatorioRepository {
    // LIST: categorías de ejemplo
    private val categoriasSimuladas = listOf(
        Categoria("Personal"),
        Categoria("Trabajo"),
        Categoria("Estudio"),
        Categoria("Personal")
    )

    // SET: elimina categorías repetidas
    val categorias: Set<Categoria> =
        categoriasSimuladas.toSet()

    // MAP: asigna un color a cada categoría
    val coloresCategorias: Map<Categoria, Color> = mapOf(
        Categoria("Personal") to Color(0xFF9C27B0),
        Categoria("Trabajo") to Color(0xFF1976D2),
        Categoria("Estudio") to Color(0xFF388E3C)
    )

    // LIST: recordatorios simulados
    val recordatorios: List<Recordatorio> = listOf(
        Recordatorio(
            id = 1,
            titulo = "Comprar alimentos",
            descripcion = "Comprar frutas y verduras",
            categoria = Categoria("Personal"),
            prioridad = Prioridad.Alta,
            estado = Estado.Pendiente,
            ubicacion = "Supermercado"
        ),
        Recordatorio(
            id = 2,
            titulo = "Estudiar Kotlin",
            descripcion = "Repasar data classes y sealed classes",
            categoria = Categoria("Estudio"),
            prioridad = Prioridad.Media,
            estado = Estado.EnProgreso,
            aviso = "18:00"
        ),
        Recordatorio(
            id = 3,
            titulo = "Enviar documentación",
            categoria = Categoria("Trabajo"),
            prioridad = Prioridad.Baja,
            estado = Estado.Completado
        ),
        Recordatorio(
            id = 4,
            titulo = "Preparar reunión",
            categoria = Categoria("Trabajo"),
            prioridad = Prioridad.Alta,
            estado = Estado.Pendiente
        )
    )

    // Filtrar recordatorios por estado
    fun filtrarPorEstado(
        estado: Estado
    ): List<Recordatorio> {
        return recordatorios.filter {
            it.estado == estado
        }
    }

    // Filtrar recordatorios por prioridad
    fun filtrarPorPrioridad(
        prioridad: Prioridad
    ): List<Recordatorio> {
        return recordatorios.filter {
            it.prioridad == prioridad
        }
    }

    // Obtener el color correspondiente a una categoría
    fun obtenerColorCategoria(
        categoria: Categoria
    ): Color {
        return coloresCategorias[categoria] ?: Color.Gray
    }
}