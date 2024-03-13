package com.ferrer.johnoliver.block1.project.soriesthriftshop

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ferrer.johnoliver.block1.project.soriesthriftshop.databinding.FragmentProfileBinding
import android.content.Context

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set click listener for the button after binding initialization
        binding.out.setOnClickListener {
            SessionManager.setLoggedIn(requireContext(), false) // Logging out the user
            startWelcomeActivity()
        }
    }

    private fun startWelcomeActivity() {
        val intent = Intent(requireActivity(), WelcomeActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
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
