package com.Tecnocratas.hackatecr6.Paquete1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Representa una publicación o un item en la lista principal.
 *
 * @property id Un identificador único para la publicación.
 * @property title El título de la publicación.
 * @property description Una descripción corta para la vista de lista (RecyclerView).
 * @property fullDescription Una descripción completa para la pantalla de detalles.
 * @property postImageResId La referencia (ID) al recurso drawable de la imagen principal del post.
 * @property author El objeto User que creó esta publicación.
 */
@Parcelize
data class Post(
    val id: String,
    val title: String,
    val description: String,
    val fullDescription: String,
    val postImageResId: Int,
    val author: User
) : Parcelable