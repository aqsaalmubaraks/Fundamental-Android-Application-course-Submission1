package com.example.githubuser

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.githubuser.databinding.ItemUserBinding


class UserAdapter (private val arrayListUser: ArrayList<User>):
RecyclerView.Adapter<UserAdapter.UserViewHolder>() {


    inner class UserViewHolder(private val binding: ItemUserBinding) :
    RecyclerView.ViewHolder(binding.root){

        fun bind(user: User){
            with(binding) {
                Glide.with(itemView.context)
                    .load(user.avatar)
                    .apply(RequestOptions())
                    .into(foto)

                username.text = user.username
                nama.text = user.name
                lokasi.text = user.location
            }

            itemView.setOnClickListener {
                val kirimData = Intent(itemView.context, UserDetail::class.java)
                kirimData.putExtra(UserDetail.EXTRA_DATA, user)
                itemView.context.startActivity(kirimData)
            }
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) = holder.bind(arrayListUser[position])


    override fun getItemCount(): Int = arrayListUser.size

}