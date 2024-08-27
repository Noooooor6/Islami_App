package com.example.islami.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startHomeActivity()
    }

    private fun startHomeActivity() {
        Handler(Looper.getMainLooper()).postDelayed({intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()},2000)

    }
}