package com.Tecnocratas.hackatecr6.Paquete1

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.card.MaterialCardView
import com.Tecnocratas.hackatecr6.R

class TradeDetailActivity : AppCompatActivity() {

    private lateinit var ivMyOfferItem: ImageView
    private var myOfferImageUri: Uri? = null

    // Lanzador para seleccionar una imagen de la galería
    private val pickImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            myOfferImageUri = it
            ivMyOfferItem.setImageURI(it)
            // Podrías añadir un campo para que el usuario nombre su oferta
            findViewById<TextView>(R.id.tvMyOfferItemName).text = "Imagen seleccionada"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trade_detail)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }

        // Obtener el objeto Post del Intent
        val post: Post? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("POST_DATA", Post::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("POST_DATA")
        }

        // Si el post es nulo, cerramos la actividad para evitar crashes
        if (post == null) {
            finish()
            return
        }

        // Enlazar vistas
        val tvPostTitle: TextView = findViewById(R.id.tvPostTitle)
        val tvPostAuthor: TextView = findViewById(R.id.tvPostAuthor)
        val ivPostImage: ImageView = findViewById(R.id.ivPostImage)
        val tvPostDescription: TextView = findViewById(R.id.tvPostDescription)
        val ivRequestedItem: ImageView = findViewById(R.id.ivRequestedItem)
        val tvRequestedItemName: TextView = findViewById(R.id.tvRequestedItemName)
        val cardMyOffer: MaterialCardView = findViewById(R.id.cardMyOffer)
        ivMyOfferItem = findViewById(R.id.ivMyOfferItem)
        val btnProposeTrade: Button = findViewById(R.id.btnProposeTrade)

        // Poblar las vistas con los datos del Post
        tvPostTitle.text = post.title
        tvPostAuthor.text = "por ${post.author.name}"
        ivPostImage.setImageResource(post.postImageResId)
        tvPostDescription.text = post.fullDescription
        ivRequestedItem.setImageResource(post.requestedItemImageResId)
        tvRequestedItemName.text = post.requestedItemName

        // Configurar listeners
        cardMyOffer.setOnClickListener {
            pickImageLauncher.launch("image/*")
        }

        btnProposeTrade.setOnClickListener {
            if (myOfferImageUri != null) {
                Toast.makeText(this, "¡Propuesta de intercambio enviada!", Toast.LENGTH_LONG).show()
                // Aquí iría la lógica para enviar la propuesta al backend o a través de un sistema de mensajería
            } else {
                Toast.makeText(this, "Por favor, selecciona una imagen para tu oferta", Toast.LENGTH_SHORT).show()
            }
        }
    }
}