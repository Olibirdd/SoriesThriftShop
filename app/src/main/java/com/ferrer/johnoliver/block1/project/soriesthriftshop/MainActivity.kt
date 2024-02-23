package com.ferrer.johnoliver.block1.project.soriesthriftshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ferrer.johnoliver.block1.project.soriesthriftshop.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomNavigationView = findViewById(R.id.bottomNav)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.homeFragment -> {
                    startActivity(Intent(this@MainActivity, HomeActivity::class.java))
                    true
                }
                R.id.favFragment -> {
                    startActivity(Intent(this@MainActivity, FavouritesActivity::class.java))
                    true
                }
                R.id.cartFragment -> {
                    startActivity(Intent(this@MainActivity, CartActivity::class.java))
                    true
                }
                R.id.profileFragment -> {
                    startActivity(Intent(this@MainActivity, ProfileActivity::class.java))
                    true
                }
                else -> false
            }
        }

        // Set default selection
        bottomNavigationView.selectedItemId = R.id.homeFragment
    }
}
