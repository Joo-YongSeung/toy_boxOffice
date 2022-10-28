package com.greedy.boxoffice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.greedy.boxoffice.databinding.ActivityReviewmakeBinding

class reviewmake : AppCompatActivity() {
    val binding by lazy { ActivityReviewmakeBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}