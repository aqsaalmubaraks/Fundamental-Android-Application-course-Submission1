package com.example.githubuser

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.githubuser.databinding.ActivityUserDetailBinding

class UserDetail : AppCompatActivity() {
   private lateinit var bind: ActivityUserDetailBinding
    lateinit var btnShare: Button

    companion object{
        var EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind= ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(bind.root)

        btnShare = findViewById(R.id.btnShare)

        btnShare.setOnClickListener {
            val myIntent = Intent(Intent.ACTION_SEND)
            myIntent.type = "type/palin"
            val shareSub = "Hello"
            myIntent.putExtra(Intent.EXTRA_TEXT , shareSub)
            startActivity(Intent.createChooser(myIntent , "Share Me"))
        }
        getData()

        val actionBar = supportActionBar
        actionBar!!.title = "Detail User"
        actionBar.setDisplayHomeAsUpEnabled(true)

    }

    @SuppressLint("SetTextI18n")
    private fun getData() {
        val Data = intent.getParcelableExtra<User>(EXTRA_DATA) as User
        bind.AvatarDetail.setImageResource(Data.avatar)
        bind.Name.text = Data.name
        bind.UserName.text = Data.username
        bind.Followers.text = """
            Followers : ${Data.follower}
        """.trimIndent()
        bind.Following.text = """
            Following : ${Data.following}
        """.trimIndent()
        bind.Repository.text = """
            Repository : ${Data.repo}
        """.trimIndent()
        bind.Company.text = Data.company
        bind.Location.text = Data.location
        title = Data.name
    }
}