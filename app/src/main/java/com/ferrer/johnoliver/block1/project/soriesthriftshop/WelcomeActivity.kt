package com.ferrer.johnoliver.block1.project.soriesthriftshop

import android.content.Intent
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
            intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener {
            intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }
    }
}