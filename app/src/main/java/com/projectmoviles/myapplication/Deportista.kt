package com.projectmoviles.myapplication

data class Deportista(
    val nombre: String = "",
    val correo: String = "",
    var contrasenia: String = "",
    var centroDeportivo: String = ""
){
    constructor() : this("", "", "", "")
}