package com.ferrer.johnoliver.block1.project.soriesthriftshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ferrer.johnoliver.block1.project.soriesthriftshop.databinding.FragmentLoginBinding
import androidx.fragment.app.FragmentManager
import android.content.Intent
import com.ferrer.johnoliver.block1.project.soriesthriftshop.MainActivity
import com.ferrer.johnoliver.block1.project.soriesthriftshop.R


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button3.setOnClickListener {
            startMainActivity()
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
            .addToBackStack(null) // This adds the transaction to the back stack
            .commit()
    }
}

