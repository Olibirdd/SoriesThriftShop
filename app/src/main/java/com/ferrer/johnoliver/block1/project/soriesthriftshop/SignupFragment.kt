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

class SignupFragment : Fragment() {

    private lateinit var binding: FragmentSignupBinding

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
        binding.button4.setOnClickListener {
            startLoginFragment()
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
