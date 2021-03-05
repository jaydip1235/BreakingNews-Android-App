package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide



class NewsAdapter(private val context: Context, private val list: List<Article>): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val titleText = itemView.findViewById<TextView>(R.id.titleText)
        val descText = itemView.findViewById<TextView>(R.id.descText)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val newsLayout = itemView.findViewById<CardView>(R.id.newsLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.titleText.text = list[position].title
        holder.descText.text = list[position].description

        Glide.with(context)
            .load(list[position].urlToImage)
            .into(holder.imageView)

        holder.newsLayout.setOnClickListener {
            val intent = Intent(context, ArticleActivity::class.java)
            intent.putExtra("title", list[position].title)
            intent.putExtra("desc", list[position].description)
            intent.putExtra("urlInfo" , list[position].url)
            context.startActivity(intent)
        }
    }
}