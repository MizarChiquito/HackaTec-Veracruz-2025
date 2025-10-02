package com.Tecnocratas.hackatecr6.Paquete1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Post(
    val id: String,
    val title: String,
    val description: String, // Descripción corta para la lista
    val fullDescription: String, // Descripción completa para detalles
    val postImageResId: Int, // La imagen principal del post (para la pantalla de detalles)
    val author: User
) : Parcelable