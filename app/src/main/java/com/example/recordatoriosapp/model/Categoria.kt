package com.example.recordatoriosapp.model

data class Categoria(
    val nombre: String
) {
    init {
        require(nombre.isNotBlank()) {
            "El nombre de la categoría es obligatorio"
        }
    }
}
