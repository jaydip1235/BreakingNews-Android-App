package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        val title = intent.getStringExtra("title")
        val desc = intent.getStringExtra("desc")
        val url = intent.getStringExtra("urlInfo")

        val articleTitle: TextView = findViewById(R.id.articleTitle)
        val articleDesc: TextView = findViewById(R.id.articleDesc)

        articleTitle.text = title
        articleDesc.text = desc
        val read  : Button = findViewById(R.id.button)

        read.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

    }
}