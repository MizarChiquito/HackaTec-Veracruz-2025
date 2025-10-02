package com.Tecnocratas.hackatecr6.Paquete1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.Tecnocratas.hackatecr6.R

class Inicio : AppCompatActivity() {

    // Variables de la clase para acceder a ellas desde cualquier método
    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter
    private val postList = mutableListOf<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inicio)

        // Llamamos a los métodos que organizan la lógica
        setupRecyclerView()
        loadSampleData()
    }

    /**
     * Inicializa el RecyclerView, asigna su LayoutManager y crea el Adaptador.
     */
    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerViewPosts)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // El adaptador necesita la lista y las funciones a ejecutar al hacer clic
        postAdapter = PostAdapter(postList, this::onPostClicked, this::onProfileClicked)
        recyclerView.adapter = postAdapter
    }

    /**
     * Se ejecuta cuando el usuario hace clic en una tarjeta de post completa.
     * Abre la pantalla de detalles del intercambio (TradeDetailActivity).
     */
    private fun onPostClicked(post: Post) {
        val intent = Intent(this, TradeDetailActivity::class.java).apply {
            // Pasamos el objeto Post completo, que es más limpio y contiene toda la info
            putExtra("POST_DATA", post)
        }
        startActivity(intent)
    }

    /**
     * Se ejecuta cuando el usuario hace clic en la imagen de perfil de un autor.
     * Abre la pantalla de detalles del perfil (ProfileDetailActivity).
     */
    private fun onProfileClicked(user: User) {
        val intent = Intent(this, ProfileDetailActivity::class.java).apply {
            // Pasamos el objeto User completo a la actividad de perfil
            putExtra("USER_DATA", user)
        }
        startActivity(intent)
    }

    /**
     * Crea y carga la lista de datos de ejemplo.
     * En una aplicación real, estos datos vendrían de una API o base de datos.
     */
    private fun loadSampleData() {
        // --- Definición completa de todos los usuarios de ejemplo ---
        val user1 = User("u1", "Ana García", R.drawable.ic_account, 12, 4.2f, "Apasionada por las mañanas productivas y el desarrollo personal. Me encanta compartir mi experiencia para ayudar a otros a crecer.")
        val user2 = User("u2", "Luis Pérez", R.drawable.ic_exchange, 8, 3.8f, "Amante de la naturaleza y los viajes. Siempre en busca de la próxima aventura y de compartir mis descubrimientos con la comunidad.")
        val user3 = User("u3", "Marta Soto", R.drawable.ic_crowdfunding, 25, 4.7f, "Chef casera y entusiasta de la cocina rápida y saludable. Mi misión es demostrar que comer bien no tiene por qué ser complicado ni aburrido.")
        val user4 = User("u4", "Carlos Ruiz", R.drawable.ic_networking, 30, 4.9f, "Ingeniero de software con una década de experiencia. Siempre aprendiendo y compartiendo trucos para escribir código más eficiente y elegante.")
        val user5 = User("u5", "Elena Castro", R.drawable.ic_home, 18, 4.5f, "Diseñadora de interiores con un ojo para la decoración DIY. Creo firmemente que un hogar hermoso y funcional está al alcance de todos.")

        // --- Creación de la lista completa de posts, incluyendo los nuevos campos ---
        val samplePosts = listOf(
            Post(
                id = "p1",
                title = "Juego de mesa casi nuevo",
                description = "Busco intercambiar Catan, jugado solo dos veces.",
                fullDescription = "Vendo o intercambio mi juego de mesa Catan. Está en perfectas condiciones, con todas sus piezas. Ideal para noches de juegos en familia o con amigos.",
                postImageResId = R.drawable.ic_networking, // Reemplaza con una imagen real de un juego
                author = user1,
                requestedItemName = "Libro de Fantasía",
                requestedItemImageResId = R.drawable.ic_exchange // Reemplaza con imagen de un libro
            ),
            Post(
                id = "p2",
                title = "Mochila de senderismo 60L",
                description = "Ofrezco mochila de montaña, poco uso.",
                fullDescription = "Mochila de senderismo de 60 litros, ideal para viajes largos o acampadas. Múltiples compartimentos y muy cómoda. La cambio por una buena tienda de campaña para dos personas.",
                postImageResId = R.drawable.ic_exchange,
                author = user2,
                requestedItemName = "Tienda de campaña",
                requestedItemImageResId = R.drawable.ic_home
            ),
            Post(
                id = "p3",
                title = "Set de cuchillos de chef",
                description = "Set profesional de acero alemán.",
                fullDescription = "Set de cuchillos de chef de alta calidad, apenas sin uso. Vienen con su estuche original. Me interesaría intercambiarlos por una cafetera de expreso en buen estado.",
                postImageResId = R.drawable.ic_crowdfunding,
                author = user3,
                requestedItemName = "Cafetera Expreso",
                requestedItemImageResId = R.drawable.ic_networking
            ),
            Post(
                id = "p4",
                title = "Teclado mecánico RGB",
                description = "Intercambio teclado gamer por monitor.",
                fullDescription = "Teclado mecánico con switches Cherry MX Red y retroiluminación RGB configurable. Perfecto para gaming y programación. Busco un monitor de 24 pulgadas o más.",
                postImageResId = R.drawable.ic_networking,
                author = user4,
                requestedItemName = "Monitor 24\"",
                requestedItemImageResId = R.drawable.ic_account
            ),
            Post(
                id = "p5",
                title = "Lámpara de diseño vintage",
                description = "Ofrezco lámpara de los años 70, funciona perfecto.",
                fullDescription = "Esta lámpara de pie tiene un estilo retro único. Funciona perfectamente y es ideal para darle un toque especial a tu sala de estar. La intercambio por alguna planta de interior grande.",
                postImageResId = R.drawable.ic_home, // Reemplaza con imagen de una lámpara
                author = user5,
                requestedItemName = "Planta de Interior",
                requestedItemImageResId = R.drawable.ic_crowdfunding // Reemplaza con imagen de una planta
            )
        )

        // Se limpia la lista por si acaso y se añaden todos los datos nuevos
        postList.clear()
        postList.addAll(samplePosts)
        // Se notifica al adaptador que los datos han cambiado para que redibuje la lista
        postAdapter.notifyDataSetChanged()
    }
}