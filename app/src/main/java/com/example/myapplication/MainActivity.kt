package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        getNews()
    }

    private fun getNews() {
        val news = NewsService.newsInstance.fetchHeadlines("in", Constants.API_KEY)
        news.enqueue(object: Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("Qwe", t.message!!)
            }
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val newsResponse = response.body()
               recyclerView?.adapter = NewsAdapter(this@MainActivity, newsResponse?.articles!!)
                recyclerView?.layoutManager = LinearLayoutManager(this@MainActivity)
            }
        })

    }

}