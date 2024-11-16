package com.example.drappoinmentapp.Activity

import android.content.Intent
import android.os.Bundle
import com.example.drappoinmentapp.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            startBtn.setOnClickListener {
                startActivity(Intent (this@SplashScreenActivity, MainActivity::class.java))
            }
        }
    }
}