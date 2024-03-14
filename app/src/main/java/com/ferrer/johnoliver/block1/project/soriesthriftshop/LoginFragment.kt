package com.ferrer.johnoliver.block1.project.soriesthriftshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ferrer.johnoliver.block1.project.soriesthriftshop.databinding.FragmentLoginBinding
import androidx.fragment.app.FragmentManager
import android.content.Intent
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.ferrer.johnoliver.block1.project.soriesthriftshop.R
import android.content.Context
import android.content.SharedPreferences


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var dbHelper: DatabaseHelper
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the SQLite database helper
        dbHelper = DatabaseHelper(requireContext())

        // Initialize SharedPreferences
        sharedPreferences = requireContext().getSharedPreferences("myPrefs", Context.MODE_PRIVATE)

        binding.button3.setOnClickListener {
            val username = binding.Uname.text.toString().trim()
            val password = binding.pass.text.toString().trim()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                if (dbHelper.verifyUser(username, password)) {
                    Toast.makeText(requireContext(), "Login successful!", Toast.LENGTH_SHORT).show()
                    // Store username in SharedPreferences
                    sharedPreferences.edit().putString("username", username).apply()
                    startMainActivity()
                } else {
                    Toast.makeText(requireContext(), "Invalid username or password", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Username and password are required", Toast.LENGTH_SHORT).show()
            }
        }
        binding.sign.setOnClickListener {
            startSignupFragment()
        }
    }

    private fun startMainActivity() {
        val intent = Intent(requireActivity(), MainActivity::class.java)
        startActivity(intent)
        requireActivity().finish() // Optional: finish the current activity
    }


    private fun startSignupFragment() {
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(android.R.id.content, SignupFragment())
            .addToBackStack(null)
            .commit()
    }
}

