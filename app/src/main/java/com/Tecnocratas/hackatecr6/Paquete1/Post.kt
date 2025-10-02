package com.Tecnocratas.hackatecr6.Paquete1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Post(
    val id: String,
    val title: String,          // Lo que se ofrece
    val description: String,
    val fullDescription: String,
    val postImageResId: Int,    // Imagen de lo que se ofrece
    val author: User,
    // --- AQUÍ NACE ---
    val requestedItemName: String, // El NOMBRE del artículo que se pide
    val requestedItemImageResId: Int // La IMAGEN del artículo que se pide
) : Parcelable