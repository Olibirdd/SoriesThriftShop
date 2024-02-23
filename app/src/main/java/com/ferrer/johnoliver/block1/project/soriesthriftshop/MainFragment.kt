package com.ferrer.johnoliver.block1.project.soriesthriftshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ferrer.johnoliver.block1.project.soriesthriftshop.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMainBinding.inflate(inflater,container,false)

        binding.button2.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment3_to_loginFragment)
        }
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment3_to_signupFragment)
        }

        return binding.root
    }
}