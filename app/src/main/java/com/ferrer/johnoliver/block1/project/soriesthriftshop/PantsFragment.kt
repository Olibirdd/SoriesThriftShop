package com.ferrer.johnoliver.block1.project.soriesthriftshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.ferrer.johnoliver.block1.project.soriesthriftshop.databinding.FragmentPantsBinding

class PantsFragment : Fragment() {
    private lateinit var binding: FragmentPantsBinding

    private val favoritesViewModel: FavouritesViewModel by activityViewModels()
    private val cartViewModel: CartViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPantsBinding.inflate(inflater, container, false)
        binding.button5.setOnClickListener {
            requireActivity().onBackPressed()
        }

        val addToCartButtonIds = arrayOf(
            R.id.add, R.id.add1, R.id.add2, R.id.add3, R.id.add4,
            R.id.add5, R.id.add6, R.id.add7, R.id.add9, R.id.add10,
            R.id.add11, R.id.add12, R.id.add13, R.id.add14, R.id.add15,
            R.id.add16, R.id.add17, R.id.add18, R.id.add19, R.id.add20
        )

        for (buttonId in addToCartButtonIds) {
            binding.root.findViewById<Button>(buttonId)?.setOnClickListener {
                val itemName = getImageNameForItemId(buttonId)
                val itemId = getImageIdForItem(itemName)
                addToCart(itemId, itemName)
            }
        }

        val addToFavoritesButtonIds = arrayOf(
            R.id.fav, R.id.fav1, R.id.fav2, R.id.fav3, R.id.fav4,
            R.id.fav5, R.id.fav6, R.id.fav7, R.id.fav9, R.id.fav10,
            R.id.fav11, R.id.fav12, R.id.fav13, R.id.fav14, R.id.fav15,
            R.id.fav16, R.id.fav17, R.id.fav18, R.id.fav19, R.id.fav20
        )

        for (buttonId in addToFavoritesButtonIds) {
            binding.root.findViewById<Button>(buttonId)?.setOnClickListener {
                val itemName = getImageNameForItemId(buttonId)
                val itemId = getImageIdForItem(itemName)
                addToFavourites(itemId,itemName)
            }
        }

        return binding.root
    }

    private fun getImageNameForItemId(buttonId: Int): String {
        return when (buttonId) {
            R.id.add -> "Baggy Pants"
            R.id.add1 -> "Blue Pants with White Belt"
            R.id.add2 -> "Classic Cutoffs"
            R.id.add3 -> "Denim Jeans"
            R.id.add4 -> "Cider Waist Tie Trouser"
            R.id.add5 -> "Fly Solid Wide Leg Pants"
            R.id.add6 -> "High Waist Baggy Pants"
            R.id.add7 -> "High Waist Pants"
            R.id.add9 -> "High Waisted Wide Leg Trouser"
            R.id.add10 -> "High Waist Pants"
            R.id.add11 -> "Jogging Pants"
            R.id.add12 -> "Antique Denim Dungarees"
            R.id.add13 -> "Retro Low Waist Jeans"
            R.id.add14 -> "Super High Waisted Button Front Wide Leg"
            R.id.add15 -> "Trouser"
            R.id.add16 -> "Classic Corduroy"
            R.id.add17 -> "Nostalgic High Waisted"
            R.id.add18 -> "Retro Flare Trousers"
            R.id.add19 -> "Timeless Tweed"
            R.id.add20 -> "Vintage Velvet"
            R.id.fav -> "Baggy Pants"
            R.id.fav1 -> "Blue Pants with White Belt"
            R.id.fav2 -> "Classic Cutoffs"
            R.id.fav3 -> "Denim Jeans"
            R.id.fav4 -> "Cider Waist Tie Trouser"
            R.id.fav5 -> "Fly Solid Wide Leg Pants"
            R.id.fav6 -> "High Waist Baggy Pants"
            R.id.fav7 -> "High Waist Pants"
            R.id.fav9 -> "High Waisted Wide Leg Trouser"
            R.id.fav10 -> "High Waist Pants"
            R.id.fav11 -> "Jogging Pants"
            R.id.fav12 -> "Antique Denim Dungarees"
            R.id.fav13 -> "Retro Low Waist Jeans"
            R.id.fav14 -> "Super High Waisted Button Front Wide Leg"
            R.id.fav15 -> "Trouser"
            R.id.fav16 -> "Classic Corduroy"
            R.id.fav17 -> "Nostalgic High Waisted"
            R.id.fav18 -> "Retro Flare Trousers"
            R.id.fav19 -> "Timeless Tweed"
            R.id.fav20 -> "Vintage Velvet"
            else -> "" // If no matching image, return an empty string
        }
    }

    private fun getImageIdForItem(itemName: String): Int {
        // Implement the mapping of item name to image resource ID
        return when (itemName) {
            "Baggy Pants" -> R.drawable.baggy_pants
            "Blue Pants with White Belt" -> R.drawable.blue_pants_with_white_belt
            "Classic Cutoffs" -> R.drawable.classic_cutoffs
            "Denim Jeans" -> R.drawable.denim_jeans
            "Cider Waist Tie Trouser" -> R.drawable.cider_waist_tie_trouser
            "Fly Solid Wide Leg Pants" -> R.drawable.fly_solid_wide_leg_pants
            "High Waist Baggy Pants" -> R.drawable.high_waist_baggy_pants
            "High Waist Pants" -> R.drawable.high_waist_pants
            "High Waisted Wide Leg Trouser" -> R.drawable.high_waisted_wide_leg_trouser
            "High Waist Pants" -> R.drawable.hight_waist_pants
            "Jogging Pants" -> R.drawable.jogging_pants
            "Antique Denim Dungarees" -> R.drawable.antique_denim_dungerees
            "Retro Low Waist Jeans" -> R.drawable.retro_low_waist_jeans
            "Super High Waisted Button Front Wide Leg" -> R.drawable.super_high_waisted_button_front_wide_leg
            "Trouser" -> R.drawable.trouser
            "Classic Corduroy" -> R.drawable.classic_corduroy
            "Nostalgic High Waisted" -> R.drawable.nostalgic_high_waisted
            "Retro Flare Trousers" -> R.drawable.retro_flare_trousers
            "Timeless Tweed" -> R.drawable.timeless_tweed
            "Vintage Velvet" -> R.drawable.vintage_velvet
            else -> 0 // If no matching image, return 0
        }
    }
    private fun addToCart(itemId: Int, itemName: String) {
        // Assuming cartViewModel is an instance of CartViewModel
        cartViewModel.addToCart(itemId, itemName)
        Toast.makeText(context, "Item is added to cart", Toast.LENGTH_SHORT).show()
    }
    private fun addToFavourites(itemId: Int, itemName: String) {
        // Assuming favoritesViewModel is an instance of FavouritesViewModel
        favoritesViewModel.addToFavourites(itemId, itemName)
        Toast.makeText(context, "Item is added to favourites", Toast.LENGTH_SHORT).show()
    }
}
