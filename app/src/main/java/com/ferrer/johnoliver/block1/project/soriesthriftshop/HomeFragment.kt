package com.ferrer.johnoliver.block1.project.soriesthriftshop

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels

class HomeFragment : Fragment() {

    private val cartViewModel: CartViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val buttonIds = arrayOf(
            R.id.add, R.id.add1, R.id.add2, R.id.add3, R.id.add4,
            R.id.add5, R.id.add6, R.id.add7, R.id.add9, R.id.add10,
            R.id.add11, R.id.add12, R.id.add13, R.id.add14, R.id.add15,
            R.id.add16, R.id.add17, R.id.add18, R.id.add19, R.id.add20
        )

        for (buttonId in buttonIds) {
            view.findViewById<Button>(buttonId).setOnClickListener {
                val itemName = "Item ${buttonIds.indexOf(buttonId) + 1}"
                addToCart(itemName)
            }
        }

        return view
    }

    private fun addToCart(itemName: String) {
        cartViewModel.addToCart(itemName)
        Toast.makeText(context, "$itemName added to cart", Toast.LENGTH_SHORT).show()
    }
}








