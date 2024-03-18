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
import androidx.fragment.app.activityViewModels


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var sharedPreferences: SharedPreferences
    private val cartViewModel: CartViewModel by activityViewModels()
    private val favoritesViewModel: FavouritesViewModel by activityViewModels()
    private val checkoutViewModel: CheckoutViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireContext().getSharedPreferences("myPrefs", Context.MODE_PRIVATE)

        val username = sharedPreferences.getString("username", "DefaultUsername")

        binding.textViewUsername.text = username

        cartViewModel.cartItemCount.observe(viewLifecycleOwner, Observer { count ->
            binding.cartItemCountTextView.text = "Cart Items: $count"
        })

        favoritesViewModel.favouritesCount.observe(viewLifecycleOwner, Observer { count ->
            binding.favoritesCountTextView.text = "Favorites: $count"
        })

        checkoutViewModel.checkedOutItemCount.observe(viewLifecycleOwner, Observer { count ->
            binding.checkOutCountTextView.text = "Checked Out Items: $count"
        })

        binding.out.setOnClickListener {
            SessionManager.setLoggedIn(requireContext(), false)
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
