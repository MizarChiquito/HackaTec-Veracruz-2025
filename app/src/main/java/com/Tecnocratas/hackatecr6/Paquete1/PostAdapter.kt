package com.Tecnocratas.hackatecr6.Paquete1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.Tecnocratas.hackatecr6.R

class PostAdapter(
    private val postList: List<Post>,
    private val onPostClick: (Post) -> Unit,
    private val onProfileClick: (User) -> Unit
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postImage: ImageView = itemView.findViewById(R.id.ivPostImage)
        val postTitle: TextView = itemView.findViewById(R.id.tvPostTitle)
        val postDescription: TextView = itemView.findViewById(R.id.tvPostDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false) // Asegúrate de tener item_post.xml
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentPost = postList[position]

        holder.postImage.setImageResource(currentPost.author.profileImageResId)
        holder.postTitle.text = currentPost.title
        holder.postDescription.text = currentPost.description

        // Listener para hacer clic en toda la tarjeta del post
        holder.itemView.setOnClickListener {
            onPostClick(currentPost)
        }

        // Listener para hacer clic en la imagen de perfil del autor
        holder.postImage.setOnClickListener {
            onProfileClick(currentPost.author)
        }
    }

    override fun getItemCount() = postList.size
}