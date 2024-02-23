package com.ferrer.johnoliver.block1.project.soriesthriftshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ferrer.johnoliver.block1.project.soriesthriftshop.databinding.ActivityLoginBinding
import com.ferrer.johnoliver.block1.project.soriesthriftshop.databinding.ActivitySignupBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button3.setOnClickListener {
            intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }

        binding.sign.setOnClickListener {
            intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }

    }
}