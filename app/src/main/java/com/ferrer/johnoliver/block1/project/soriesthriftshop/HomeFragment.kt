package com.ferrer.johnoliver.block1.project.soriesthriftshop
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.ferrer.johnoliver.block1.project.soriesthriftshop.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        binding.shirts.setOnClickListener{
            startVintageFragment()
        }

        return binding.root
    }
    private fun startVintageFragment() {
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(android.R.id.content, VintageFragment())
            .addToBackStack(null)
            .commit()
    }
}
