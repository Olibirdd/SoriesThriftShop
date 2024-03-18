package com.ferrer.johnoliver.block1.project.soriesthriftshop
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
import com.ferrer.johnoliver.block1.project.soriesthriftshop.CartFavouritesListener
import com.ferrer.johnoliver.block1.project.soriesthriftshop.DatabaseHelper
import com.ferrer.johnoliver.block1.project.soriesthriftshop.FavouritesFragment
import com.ferrer.johnoliver.block1.project.soriesthriftshop.HomeFragment
// Add the CartFavoritesListener interface
class MainActivity : AppCompatActivity(), CartFavouritesListener.CartFavoritesListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = DatabaseHelper(this)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        val isLoggedIn = ProfileFragment.SessionManager.isLoggedIn(this)

        if (isLoggedIn) {

            loadFragment(HomeFragment())
        } else {
            loadFragment(ProfileFragment())
        }
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

    override fun addToCart() {
        Toast.makeText(this, "Item added to cart", Toast.LENGTH_SHORT).show()
    }

    override fun addToFavorites() {
        Toast.makeText(this, "Item added to favorites", Toast.LENGTH_SHORT).show()
    }
}
