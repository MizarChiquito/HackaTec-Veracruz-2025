package com.Tecnocratas.hackatecr6.Paquete1
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: String,
    val name: String,
    val profileImageResId: Int,
    val dealsMade: Int,
    val rating: Float,
    val bio: String
) : Parcelable