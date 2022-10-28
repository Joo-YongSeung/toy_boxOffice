package com.greedy.boxoffice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.greedy.boxoffice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.testbts.setOnClickListener {
            val intent = Intent(this, moviedetail::class.java)
            startActivity(intent)

            MoviesRepository.getPopularMovies()
        } }
}