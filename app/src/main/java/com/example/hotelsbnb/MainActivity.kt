package com.example.hotelsbnb

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient
import okhttp3.Request
import com.example.hotelsbnb.BuildConfig.API_KEY

class MainActivity : AppCompatActivity() {

    var maintext: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val policy = ThreadPolicy.Builder().permitAll().build()

        StrictMode.setThreadPolicy(policy)

        var maintext = findViewById<TextView>(R.id.maintext)

        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://airbnb13.p.rapidapi.com/autocomplete?query=paris")
            .get()
            .addHeader("X-RapidAPI-Key", "$API_KEY")
            .addHeader("X-RapidAPI-Host", "airbnb13.p.rapidapi.com")
            .build()

        val response = client.newCall(request).execute()

        maintext.setText(response.toString())

    }



}