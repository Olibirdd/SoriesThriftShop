package com.ferrer.johnoliver.block1.project.soriesthriftshop;


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import com.ferrer.johnoliver.block1.project.soriesthriftshop.CartFragment
import com.ferrer.johnoliver.block1.project.soriesthriftshop.ProfileFragment
import com.ferrer.johnoliver.block1.project.soriesthriftshop.R
import com.ferrer.johnoliver.block1.project.soriesthriftshop.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var dbHelper: DatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        dbHelper = DatabaseHelper(this)


        binding.bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        ProfileFragment.SessionManager.setLoggedIn(this, true)

        val isLoggedIn = ProfileFragment.SessionManager.isLoggedIn(this)


        ProfileFragment.SessionManager.setLoggedIn(this, false)





    }

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


    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}

