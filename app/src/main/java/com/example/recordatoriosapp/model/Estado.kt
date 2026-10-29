package com.example.recordatoriosapp.model
sealed class Estado(val nombre: String) {

    data object Pendiente : Estado("Pendiente")

    data object EnProgreso : Estado("En progreso")

    data object Completado : Estado("Completado")
}