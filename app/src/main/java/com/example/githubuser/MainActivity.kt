package com.example.githubuser

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            rvGithub.layoutManager = LinearLayoutManager(this@MainActivity)
            rvGithub.adapter = UserAdapter(getDataArray())
        }
    }


    @SuppressLint("Recycle")
    private fun getDataArray(): ArrayList<User> {
        val getPerusahaan = resources.getStringArray(R.array.company)
        val getUsername = resources.getStringArray(R.array.username)
        val getMengikuti = resources.getStringArray(R.array.following)
        val getFoto = resources.obtainTypedArray(R.array.avatar)
        val getPengikut = resources.getStringArray(R.array.followers)
        val getNama = resources.getStringArray(R.array.name)
        val getLokasi = resources.getStringArray(R.array.location)
        val getRepo = resources.getStringArray(R.array.repository)


        val DataUser: ArrayList<User> = arrayListOf()
        for (posisi in getNama.indices) {
            val dataUser = User(
                getFoto.getResourceId(posisi, -1),
                getNama[posisi],
                getUsername[posisi],
                getPengikut[posisi],
                getMengikuti[posisi],
                getRepo[posisi],
                getPerusahaan[posisi],
                getLokasi[posisi]
            )
            DataUser.add(dataUser)
        }
        return DataUser
    }
}