package com.ferrer.johnoliver.block1.project.soriesthriftshop;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import com.ferrer.johnoliver.block1.project.soriesthriftshop.CartFragment
import com.ferrer.johnoliver.block1.project.soriesthriftshop.FavouritesFragment
import com.ferrer.johnoliver.block1.project.soriesthriftshop.HomeFragment
import com.ferrer.johnoliver.block1.project.soriesthriftshop.ProfileFragment
import com.ferrer.johnoliver.block1.project.soriesthriftshop.R
import com.ferrer.johnoliver.block1.project.soriesthriftshop.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_favourites -> {
                    loadFragment(FavouritesFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_cart -> {
                    loadFragment(CartFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_profile -> {
                    loadFragment(ProfileFragment())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the default fragment
        loadFragment(HomeFragment())

        // Set up bottom navigation
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}