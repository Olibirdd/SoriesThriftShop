package com.ferrer.johnoliver.block1.project.soriesthriftshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ferrer.johnoliver.block1.project.soriesthriftshop.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

    }
}