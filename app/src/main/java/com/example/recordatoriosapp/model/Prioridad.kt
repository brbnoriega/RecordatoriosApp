package com.example.recordatoriosapp.model

sealed class Prioridad(val nombre: String) {

    data object Alta : Prioridad("Alta")

    data object Media : Prioridad("Media")

    data object Baja : Prioridad("Baja")
}