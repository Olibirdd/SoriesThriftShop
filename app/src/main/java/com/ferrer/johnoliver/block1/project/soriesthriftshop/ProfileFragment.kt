package com.ferrer.johnoliver.block1.project.soriesthriftshop

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.ferrer.johnoliver.block1.project.soriesthriftshop.databinding.FragmentProfileBinding
import android.content.Context
import android.content.SharedPreferences
import androidx.fragment.app.FragmentManager

class ProfileFragment : Fragment(), CartFavouritesListener.CartFavoritesListener {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var sharedPreferences: SharedPreferences
    private val cartViewModel: CartViewModel by activityViewModels()
    private val favoritesViewModel: FavouritesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize SharedPreferences
        sharedPreferences = requireContext().getSharedPreferences("myPrefs", Context.MODE_PRIVATE)

        // Retrieve username from SharedPreferences
        val username = sharedPreferences.getString("username", "DefaultUsername")

        // Set username to TextView
        binding.textViewUsername.text = username

        // Observe changes in cart items count
        cartViewModel.cartItemCount.observe(viewLifecycleOwner, Observer { count ->
            binding.cartItemCountTextView.text = "Cart Items: $count"
        })

        // Observe changes in favorites count
        favoritesViewModel.favouritesCount.observe(viewLifecycleOwner, Observer { count ->
            binding.favoritesCountTextView.text = "Favorites: $count"
        })

        // Set click listener for the logout button
        binding.out.setOnClickListener {
            SessionManager.setLoggedIn(requireContext(), false) // Logging out the user
            startWelcomeActivity()
        }
        binding.cartItemCountTextView.setOnClickListener {
            startCartFragment()
        }
        binding.favoritesCountTextView.setOnClickListener {
            startFavouritesFragment()
        }
    }

    private fun startWelcomeActivity() {
        val intent = Intent(requireActivity(), WelcomeActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }
    private fun startCartFragment() {
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(android.R.id.content, CartFragment())
            .addToBackStack(null)
            .commit()
    }
    private fun startFavouritesFragment() {
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(android.R.id.content, FavouritesFragment())
            .addToBackStack(null)
            .commit()
    }

    override fun addToCart() {
        // No need to implement here
    }

    override fun addToFavorites() {
        // No need to implement here
    }

    object SessionManager {
        private const val PREF_NAME = "MyAppPref"
        private const val KEY_IS_LOGGED_IN = "isLoggedIn"

        fun setLoggedIn(context: Context, isLoggedIn: Boolean) {
            val editor = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit()
            editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn)
            editor.apply()
        }

        fun isLoggedIn(context: Context): Boolean {
            val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            return pref.getBoolean(KEY_IS_LOGGED_IN, false)
        }
    }
}
