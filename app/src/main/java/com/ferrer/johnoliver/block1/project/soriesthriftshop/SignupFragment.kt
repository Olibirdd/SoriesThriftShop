package com.ferrer.johnoliver.block1.project.soriesthriftshop

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ferrer.johnoliver.block1.project.soriesthriftshop.databinding.FragmentSignupBinding
import androidx.fragment.app.FragmentManager
import com.ferrer.johnoliver.block1.project.soriesthriftshop.R

import android.widget.Toast
import api.DefaultResponse
import api.SoriesClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupFragment : Fragment() {

    private lateinit var binding: FragmentSignupBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button4.setOnClickListener {
            val name = binding.name.text.toString().trim()
            val email = binding.email.text.toString().trim()
            val username = binding.editText2.text.toString().trim()
            val password = binding.pword.text.toString().trim()
            val cpword = binding.editText.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                if (password == cpword) {
                    registerUser(name, username, email, password)
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
        binding.sign.setOnClickListener {
            startLoginFragment()
        }
    }

    private fun registerUser(name: String, username: String, email: String, password: String) {
        SoriesClient.instance.registerUser(name, username, email, password).enqueue(object :
            Callback<DefaultResponse> {
            override fun onResponse(call: Call<DefaultResponse>, response: Response<DefaultResponse>) {
                if (response.isSuccessful) {
                    Toast.makeText(requireContext(), "User registered successfully!", Toast.LENGTH_SHORT).show()
                    startLoginFragment()
                } else {
                    // Handle error response
                    val errorBody = response.errorBody()?.string()
                    Log.e("Error", "Error response: $errorBody")
                    Toast.makeText(requireContext(), "Failed to register user", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                Log.e("Error", "Error: ${t.message}", t)
                Toast.makeText(requireContext(), "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }


    private fun startLoginFragment() {
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(android.R.id.content, LoginFragment())
            .addToBackStack(null)
            .commit()
    }
}
