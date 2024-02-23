package com.ferrer.johnoliver.block1.project.soriesthriftshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ferrer.johnoliver.block1.project.soriesthriftshop.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

        binding = FragmentProfileBinding.inflate(inflater,container,false)

        return binding.root
    }


}