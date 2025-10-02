package com.Tecnocratas.hackatecr6.Paquete1 // Asegúrate de que tu paquete sea correcto

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.Tecnocratas.hackatecr6.R

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inicio)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewPosts)

        // Datos de ejemplo para usuarios (autores de posts)
        val user1 = User("u1", "Ana García", R.drawable.ic_account, 12, 4.2f, "Apasionada por las mañanas productivas y el desarrollo personal. Me encanta compartir mi experiencia para ayudar a otros a crecer.")
        val user2 = User("u2", "Luis Pérez", R.drawable.ic_exchange, 8, 3.8f, "Amante de la naturaleza y los viajes. Siempre en busca de la próxima aventura y de compartir mis descubrimientos con la comunidad.")
        val user3 = User("u3", "Marta Soto", R.drawable.ic_crowdfunding, 25, 4.7f, "Chef casera y entusiasta de la cocina rápida y saludable. Mi misión es demostrar que comer bien no tiene por qué ser complicado ni aburrido.")
        val user4 = User("u4", "Carlos Ruiz", R.drawable.ic_networking, 30, 4.9f, "Ingeniero de software con una década de experiencia. Siempre aprendiendo y compartiendo trucos para escribir código más eficiente y elegante.")
        val user5 = User("u5", "Elena Castro", R.drawable.ic_home, 18, 4.5f, "Diseñadora de interiores con un ojo para la decoración DIY. Creo firmemente que un hogar hermoso y funcional está al alcance de todos.")

        // Prepara tus datos de ejemplo de Posts, ahora incluyendo el autor
        val posts = listOf(
            Post(
                user1.profileImageResId, // Usar la imagen de perfil del autor
                "Mañanas Productivas",
                "Consejos para empezar el día...",
                "Empieza tu día con una rutina que te impulse. Desde meditación, ejercicio ligero hasta un desayuno nutritivo, descubre cómo cada pequeño hábito puede transformar tu productividad y bienestar general. ¡Despierta tu potencial cada mañana!",
                user1 // Asociar el objeto User al Post
            ),
            Post(
                user2.profileImageResId,
                "Aventuras al Aire Libre",
                "Descubre nuevos destinos.",
                "Explora la belleza de la naturaleza con estas rutas de senderismo y destinos de acampada. Desde montañas majestuosas hasta playas escondidas, te guiamos a la aventura perfecta. ¡Prepárate para desconectar y respirar aire fresco!",
                user2
            ),
            Post(
                user3.profileImageResId,
                "Recetas Fáciles",
                "Cocina algo delicioso en menos de 30 minutos.",
                "¿Poco tiempo pero ganas de comer rico? Aquí encontrarás recetas rápidas, saludables y deliciosas que podrás preparar en menos de 30 minutos. ¡Ideal para tus almuerzos o cenas entre semana!",
                user3
            ),
            Post(
                user4.profileImageResId,
                "Tips de Programación",
                "Mejora tu código con estos sencillos consejos.",
                "Optimiza tu flujo de trabajo y escribe código más limpio y eficiente con estos trucos y herramientas de programación. Desde atajos de teclado hasta buenas prácticas de desarrollo, eleva tus habilidades de codificación al siguiente nivel.",
                user4
            ),
            Post(
                user5.profileImageResId,
                "Decoración de Interiores",
                "Ideas para renovar tu hogar sin gastar mucho.",
                "Dale un nuevo aire a tu espacio sin necesidad de grandes inversiones. Con estos consejos de decoración, aprenderás a reutilizar, reorganizar y añadir toques personales que harán que tu hogar se sienta completamente renovado y acogedor.",
                user5
            )
        )

        // Crea una instancia del adaptador y le pasa los click listeners
        val adapter = PostAdapter(
            posts,
            onPostClick = { post ->
                // Acción al hacer clic en la tarjeta del post
                val intent = Intent(this, PostDetailActivity::class.java).apply {
                    putExtra("POST_IMAGE_RES_ID", post.imageResource)
                    putExtra("POST_TITLE", post.title)
                    putExtra("POST_DESCRIPTION", post.fullDescription)
                }
                startActivity(intent)
            },
            onProfileClick = { user ->
                // Acción al hacer clic en la imagen de perfil del post
                val intent = Intent(this, ProfileDetailActivity::class.java).apply {
                    putExtra("USER_DATA", user) // Pasamos el objeto User completo
                }
                startActivity(intent)
            }
        )

        // Asigna el adaptador al RecyclerView
        recyclerView.adapter = adapter
    }
}