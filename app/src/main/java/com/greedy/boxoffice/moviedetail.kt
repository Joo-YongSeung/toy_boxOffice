package com.greedy.boxoffice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.greedy.boxoffice.databinding.ActivityMoviedetailBinding


class moviedetail : AppCompatActivity() {
    val binding by lazy { ActivityMoviedetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.mainButton.setOnClickListener {
            val intent = Intent(this, reviewmake::class.java)
            startActivity(intent)

        }

    }
}