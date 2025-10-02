package com.Tecnocratas.hackatecr6.Paquete1

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.Tecnocratas.hackatecr6.R
import com.google.android.material.imageview.ShapeableImageView

class ProfileDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val backButton: ImageView = findViewById(R.id.back_button)
        val profileTitleTopBar: TextView = findViewById(R.id.profile_title_top_bar)
        val tvDealsMade: TextView = findViewById(R.id.tvDealsMade)
        val ivProfilePicture: ShapeableImageView = findViewById(R.id.ivProfilePicture)
        val tvProfileName: TextView = findViewById(R.id.tvProfileName)
        val starContainer: LinearLayout = findViewById(R.id.starContainer) // Contenedor de estrellas
        val tvPersonalInfo: TextView = findViewById(R.id.tvPersonalInfo)

    }
}