package com.ferrer.johnoliver.block1.project.soriesthriftshop
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.ferrer.johnoliver.block1.project.soriesthriftshop.CartViewModel
import com.ferrer.johnoliver.block1.project.soriesthriftshop.FavouritesViewModel
import com.ferrer.johnoliver.block1.project.soriesthriftshop.R

class HomeFragment : Fragment() {

    private val favoritesViewModel: FavouritesViewModel by activityViewModels()
    private val cartViewModel: CartViewModel by activityViewModels()
    private val cartItems: MutableList<String> = mutableListOf()
    private val favouriteItems: MutableList<String> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val addToCartButtonIds = arrayOf(
            R.id.add, R.id.add1, R.id.add2, R.id.add3, R.id.add4,
            R.id.add5, R.id.add6, R.id.add7, R.id.add9, R.id.add10,
            R.id.add11, R.id.add12, R.id.add13, R.id.add14, R.id.add15,
            R.id.add16, R.id.add17, R.id.add18, R.id.add19, R.id.add20
        )

        val addToFavoritesButtonIds = arrayOf(
            R.id.fav, R.id.fav1, R.id.fav2, R.id.fav3, R.id.fav4,
            R.id.fav5, R.id.fav6, R.id.fav7, R.id.fav9, R.id.fav10,
            R.id.fav11, R.id.fav12, R.id.fav13, R.id.fav14, R.id.fav15,
            R.id.fav16, R.id.fav17, R.id.fav18, R.id.fav19, R.id.fav20
        )

        for (buttonId in addToCartButtonIds) {
            view.findViewById<Button>(buttonId).setOnClickListener {
                val itemName = "Item ${addToCartButtonIds.indexOf(buttonId) + 1}"
                addToCart(itemName)
            }
        }

        for (buttonId in addToFavoritesButtonIds) {
            view.findViewById<Button>(buttonId)?.setOnClickListener {
                val itemName = "Item ${addToFavoritesButtonIds.indexOf(buttonId) + 1}"
                addToFavorites(itemName)
            }
        }

        return view
    }

    private fun addToCart(itemName: String) {
        cartViewModel.addToCart(itemName)
        Toast.makeText(context, "$itemName added to cart", Toast.LENGTH_SHORT).show()
    }
    private fun addToFavorites(itemName: String) {
        favoritesViewModel.addToFavorites(itemName)
        Toast.makeText(context, "$itemName added to favourites", Toast.LENGTH_SHORT).show()
    }
}
