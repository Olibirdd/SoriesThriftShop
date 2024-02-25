package com.ferrer.johnoliver.block1.project.soriesthriftshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ferrer.johnoliver.block1.project.soriesthriftshop.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener {
            startLoginFragment()
        }
        binding.button.setOnClickListener {
            startSignupFragment()
        }
    }

    private fun startLoginFragment() {
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, LoginFragment())
            .commit()
    }
    private fun startSignupFragment() {
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, SignupFragment())
            .commit()
    }
}

