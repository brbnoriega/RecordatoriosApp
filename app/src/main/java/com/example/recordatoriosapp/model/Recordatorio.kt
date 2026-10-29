package com.example.recordatoriosapp.model

data class Recordatorio(
    val id: Int,
    val titulo: String,
    val descripcion: String? = null,
    val categoria: Categoria,
    val prioridad: Prioridad,
    val estado: Estado,
    val ubicacion: String? = null,
    val aviso: String? = null
) {
    init {
        require(id > 0) {
            "El ID debe ser mayor a cero"
        }

        require(titulo.isNotBlank()) {
            "El título del recordatorio es obligatorio"
        }

        require(titulo.length <= 100) {
            "El título no puede superar los 100 caracteres"
        }

        require(descripcion == null || descripcion.length <= 500) {
            "La descripción no puede superar los 500 caracteres"
        }
    }
}