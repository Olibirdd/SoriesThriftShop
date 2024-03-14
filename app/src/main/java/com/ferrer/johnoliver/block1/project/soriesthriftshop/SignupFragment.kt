package com.ferrer.johnoliver.block1.project.soriesthriftshop
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ferrer.johnoliver.block1.project.soriesthriftshop.databinding.FragmentSignupBinding
import androidx.fragment.app.FragmentManager
import com.ferrer.johnoliver.block1.project.soriesthriftshop.R

import android.widget.Toast
class SignupFragment : Fragment() {

    private lateinit var binding: FragmentSignupBinding
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dbHelper = DatabaseHelper(requireContext())

        binding.button4.setOnClickListener {
            startLoginFragment()
            val username = binding.editText2.text.toString().trim()
            val password = binding.pword.text.toString().trim()
            val cpword = binding.editText.text.toString().trim()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                if (password == cpword) {
                    if (!dbHelper.getUser(username)) {
                        val result = dbHelper.addUser(username, password)
                        if (result != -1L) {
                            Toast.makeText(requireContext(), "User registered successfully!", Toast.LENGTH_SHORT).show()
                            startLoginFragment()
                        } else {
                            Toast.makeText(requireContext(), "Failed to register user", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(requireContext(), "User already exists", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(requireContext(), "Passwords do not match", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Username and password are required", Toast.LENGTH_SHORT).show()
            }
        }

        binding.login.setOnClickListener {
            startLoginFragment()
        }
    }
    private fun startLoginFragment() {
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(android.R.id.content, LoginFragment())
            .addToBackStack(null) // This adds the transaction to the back stack
            .commit()
    }
}
