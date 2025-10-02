package com.Tecnocratas.hackatecr6.Paquete1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.Tecnocratas.hackatecr6.R


import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.Toolbar

class CreatePostActivity : AppCompatActivity() {

    private lateinit var ivImagePreview: ImageView
    private var selectedImageUri: Uri? = null

    // Nuevo lanzador de actividad para seleccionar una imagen
    private val pickImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            selectedImageUri = it
            ivImagePreview.setImageURI(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() } // Cierra la actividad

        ivImagePreview = findViewById(R.id.ivImagePreview)
        val etPostTitle: EditText = findViewById(R.id.etPostTitle)
        val etPostDescription: EditText = findViewById(R.id.etPostDescription)
        val btnPublishPost: Button = findViewById(R.id.btnPublishPost)

        // Listener para seleccionar una imagen
        ivImagePreview.setOnClickListener {
            pickImageLauncher.launch("image/*") // Abre la galería para seleccionar imágenes
        }

        // Listener para el botón de publicar
        btnPublishPost.setOnClickListener {
            val title = etPostTitle.text.toString().trim()
            val description = etPostDescription.text.toString().trim()

            if (title.isEmpty() || description.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Aquí normalmente subirías la imagen a un servidor y obtendrías una URL.
            // Como no estamos usando backend, devolveremos el URI local como si fuera un ID.
            // O podemos simplemente usar un drawable de placeholder.

            val resultIntent = Intent()
            resultIntent.putExtra("NEW_POST_TITLE", title)
            resultIntent.putExtra("NEW_POST_DESCRIPTION", description)
            // Para la demo, usaremos un drawable estático. En un caso real, manejarías la URI.
            resultIntent.putExtra("NEW_POST_IMAGE_RES_ID", R.drawable.ic_networking) // Placeholder

            setResult(Activity.RESULT_OK, resultIntent)
            finish() // Cierra esta actividad y vuelve a Inicio
        }
    }
}
