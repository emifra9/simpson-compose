package com.emifra9.simpson.data.dto

import com.google.gson.annotations.SerializedName

data class Cartoon(
    val _id: String,
    @SerializedName("Nombre")
    val name: String,
    @SerializedName("Historia")
    val history: String,
    @SerializedName("Imagen")
    val imageUrl: String,
    @SerializedName("Genero")
    val gender: String,
    @SerializedName("Estado")
    val status: String,
    @SerializedName("Ocupacion")
    val occupation: String
)

data class CartoonList(
    @SerializedName("docs")
    val list: List<Cartoon>
)