package com.ferrer.johnoliver.block1.project.soriesthriftshop

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.activityViewModels

class CartFragment : Fragment() {

    private lateinit var listView: ListView
    private val cartViewModel: CartViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_cart, container, false)
        listView = view.findViewById(R.id.listView)
        setupCartObserver()
        return view
    }

    private fun setupCartObserver() {
        cartViewModel.cartItems.observe(viewLifecycleOwner) { items ->
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, items)
            listView.adapter = adapter
        }
    }
}






