package com.Tecnocratas.hackatecr6.Paquete1 // Asegúrate de que tu paquete sea correcto

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.Tecnocratas.hackatecr6.R

class Inicio : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter
    private val postList = mutableListOf<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inicio)

        setupRecyclerView()
        loadSampleData()

        // No es necesario notificar al adaptador aquí si le pasamos la lista en el constructor
        // y los datos no cambian después de la creación inicial.
    }

    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerViewPosts)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Pasamos la lista directamente al adaptador.
        postAdapter = PostAdapter(postList, this::onPostClicked, this::onProfileClicked)
        recyclerView.adapter = postAdapter
    }

    private fun onPostClicked(post: Post) {
        // ----- CORRECCIÓN 1: Nombre de la Actividad -----
        val intent = Intent(this, Activity_post_detail::class.java).apply {
            // Pasamos los datos del post a la actividad de detalles
            putExtra("POST_IMAGE_RES_ID", post.postImageResId) // Usamos la imagen principal del post
            putExtra("POST_TITLE", post.title)
            putExtra("POST_DESCRIPTION", post.fullDescription)
        }
        startActivity(intent)
    }

    private fun onProfileClicked(user: User) {
        val intent = Intent(this, ProfileDetailActivity::class.java).apply {
            putExtra("USER_DATA", user)
        }
        startActivity(intent)
    }

    private fun loadSampleData() {
        val user1 = User("u1", "Ana García", R.drawable.ic_account, 12, 4.2f, "Apasionada por las mañanas productivas y el desarrollo personal. Me encanta compartir mi experiencia para ayudar a otros a crecer.")
        val user2 = User("u2", "Luis Pérez", R.drawable.ic_exchange, 8, 3.8f, "Amante de la naturaleza y los viajes. Siempre en busca de la próxima aventura y de compartir mis descubrimientos con la comunidad.")
        val user3 = User("u3", "Marta Soto", R.drawable.ic_crowdfunding, 25, 4.7f, "Chef casera y entusiasta de la cocina rápida y saludable. Mi misión es demostrar que comer bien no tiene por qué ser complicado ni aburrido.")
        val user4 = User("u4", "Carlos Ruiz", R.drawable.ic_networking, 30, 4.9f, "Ingeniero de software con una década de experiencia. Siempre aprendiendo y compartiendo trucos para escribir código más eficiente y elegante.")
        val user5 = User("u5", "Elena Castro", R.drawable.ic_home, 18, 4.5f, "Diseñadora de interiores con un ojo para la decoración DIY. Creo firmemente que un hogar hermoso y funcional está al alcance de todos.")

        // ----- CORRECCIÓN 2: Creación de los objetos Post -----
        // Asegúrate de que tu clase Post.kt coincida con estos parámetros.
        val samplePosts = listOf(
            Post(
                id = "p1",
                title = "Mañanas Productivas",
                description = "Consejos para empezar el día...",
                fullDescription = "Empieza tu día con una rutina que te impulse. Desde meditación, ejercicio ligero hasta un desayuno nutritivo, descubre cómo cada pequeño hábito puede transformar tu productividad y bienestar general. ¡Despierta tu potencial cada mañana!",
                postImageResId = R.drawable.ic_networking, // Asignamos un INT (un drawable)
                author = user1 // Asignamos el objeto User
            ),
            Post(
                id = "p2",
                title = "Aventuras al Aire Libre",
                description = "Descubre nuevos destinos.",
                fullDescription = "Explora la belleza de la naturaleza con estas rutas de senderismo y destinos de acampada. Desde montañas majestuosas hasta playas escondidas, te guiamos a la aventura perfecta. ¡Prepárate para desconectar y respirar aire fresco!",
                postImageResId = R.drawable.ic_exchange,
                author = user2
            ),
            Post(
                id = "p3",
                title = "Recetas Fáciles",
                description = "Cocina algo delicioso en menos de 30 minutos.",
                fullDescription = "¿Poco tiempo pero ganas de comer rico? Aquí encontrarás recetas rápidas, saludables y deliciosas que podrás preparar en menos de 30 minutos. ¡Ideal para tus almuerzos o cenas entre semana!",
                postImageResId = R.drawable.ic_crowdfunding,
                author = user3
            ),
            Post(
                id = "p4",
                title = "Tips de Programación",
                description = "Mejora tu código con estos sencillos consejos.",
                fullDescription = "Optimiza tu flujo de trabajo y escribe código más limpio y eficiente con estos trucos y herramientas de programación. Desde atajos de teclado hasta buenas prácticas de desarrollo, eleva tus habilidades de codificación al siguiente nivel.",
                postImageResId = R.drawable.ic_networking,
                author = user4
            ),
            Post(
                id = "p5",
                title = "Decoración de Interiores",
                description = "Ideas para renovar tu hogar sin gastar mucho.",
                fullDescription = "Dale un nuevo aire a tu espacio sin necesidad de grandes inversiones. Con estos consejos de decoración, aprenderás a reutilizar, reorganizar y añadir toques personales que harán que tu hogar se sienta completamente renovado y acogedor.",
                postImageResId = R.drawable.ic_home,
                author = user5
            )
        )

        postList.clear()
        postList.addAll(samplePosts)
        postAdapter.notifyDataSetChanged() // Notificamos al adaptador después de añadir los datos
    }
}