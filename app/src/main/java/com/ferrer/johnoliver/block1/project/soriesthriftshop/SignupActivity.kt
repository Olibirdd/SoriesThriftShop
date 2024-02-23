package com.ferrer.johnoliver.block1.project.soriesthriftshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ferrer.johnoliver.block1.project.soriesthriftshop.databinding.ActivitySignupBinding
import com.ferrer.johnoliver.block1.project.soriesthriftshop.databinding.ActivityWelcomeBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button4.setOnClickListener {
            intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        binding.login.setOnClickListener {
            intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}