package com.ferrer.johnoliver.block1.project.soriesthriftshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.ferrer.johnoliver.block1.project.soriesthriftshop.databinding.FragmentShortsBinding

class ShortsFragment : Fragment() {

    private lateinit var binding: FragmentShortsBinding
    private val favouritesViewModel: FavouritesViewModel by activityViewModels()
    private val cartViewModel: CartViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShortsBinding.inflate(inflater, container, false)
        binding.button69.setOnClickListener {
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
                addToFavorites(itemId, itemName)
            }
        }

        return binding.root
    }

    private fun getImageNameForItemId(buttonId: Int): String {
        return when (buttonId) {
            R.id.add -> "Balmin Cargo Short"
            R.id.add1 -> "Button Decor High Waisted"
            R.id.add2 -> "Cleopatra Stone Short"
            R.id.add3 -> "Cotton Denim Short"
            R.id.add4 -> "Denim Short with Belt"
            R.id.add5 -> "Frill Waist Denim Short"
            R.id.add6 -> "Plus Flap Pocket Cargo Short"
            R.id.add7 -> "River Island High Waisted Short"
            R.id.add9 -> "Inspired Shorts"
            R.id.add10 -> "Vintage Vogue"
            R.id.add11 -> "Classic Cutoffs"
            R.id.add12 -> "Heritage Hemlines"
            R.id.add13 -> "Casual Short"
            R.id.add14 -> "Nostalgia Knickers"
            R.id.add15 -> "OldSchool Chic Bottoms"
            R.id.add16 -> "Rustic Retro Shorts"
            R.id.add17 -> "Retro Revival Shorts"
            R.id.add18 -> "Throwback Trunks"
            R.id.add19 -> "Timeless Tailored Shorts"
            R.id.add20 -> "Vintage Verve Shorts"
            R.id.fav -> "Balmin Cargo Short"
            R.id.fav1 -> "Button Decor High Waisted"
            R.id.fav2 -> "Cleopatra Stone Short"
            R.id.fav3 -> "Cotton Denim Short"
            R.id.fav4 -> "Denim Short with Belt"
            R.id.fav5 -> "Frill Waist Denim Short"
            R.id.fav6 -> "Plus Flap Pocket Cargo Short"
            R.id.fav7 -> "River Island High Waisted Short"
            R.id.fav9 -> "Inspired Shorts"
            R.id.fav10 -> "Vintage Vogue"
            R.id.fav11 -> "Classic Cutoffs"
            R.id.fav12 -> "Heritage Hemlines"
            R.id.fav13 -> "Casual Short"
            R.id.fav14 -> "Nostalgia Knickers"
            R.id.fav15 -> "OldSchool Chic Bottoms"
            R.id.fav16 -> "Rustic Retro Shorts"
            R.id.fav17 -> "Retro Revival Shorts"
            R.id.fav18 -> "Throwback Trunks"
            R.id.fav19 -> "Timeless Tailored Shorts"
            R.id.fav20 -> "Vintage Verve Shorts"
            else -> "" // If no matching image, return an empty string
        }
    }

    private fun getImageIdForItem(itemName: String): Int {
        val imageIdMap = mapOf(
            "Balmin Cargo Short" to R.drawable.balmin_cargo_short,
            "Button Decor High Waisted" to R.drawable.button_decor_high_waist_short,
            "Cleopatra Stone Short" to R.drawable.cleopatra_stone_short,
            "Cotton Denim Short" to R.drawable.cotton_denim_short,
            "Denim Short with Belt" to R.drawable.denim_short_with_belt,
            "Frill Waist Denim Short" to R.drawable.frill_waist_denim_short,
            "Plus Flap Pocket Cargo Short" to R.drawable.plus_flap_pocket_cargo_short,
            "River Island High Waisted Knicker Short" to R.drawable.river_island_high_waisted_knicker_short,
            "Inspired Shorts" to R.drawable.inspired_shorts,
            "Vintage Vogue" to R.drawable.vintage_vouge,
            "Classic Cutoffs" to R.drawable.classic_cutoffs,
            "Heritage Hemlines" to R.drawable.heritage_hemlines,
            "Casual Short" to R.drawable.casual_short,
            "Nostalgia Knickers" to R.drawable.nostalgia_knickers,
            "OldSchool Chic Bottoms" to R.drawable.oldschool_chic_bottoms,
            "Rustic Retro Shorts" to R.drawable.rustic_retro_shorts,
            "Retro Revival Shorts" to R.drawable.retro_revival_shorts,
            "Throwback Trunks" to R.drawable.throwback_trunks,
            "Timeless Tailored Shorts" to R.drawable.timeless_tailored_shorts,
            "Vintage Verve Shorts" to R.drawable.vintage_verve_shorts
        )
        return imageIdMap[itemName] ?: R.drawable.ic_person // Return default if no mapping found
    }

    private fun addToCart(itemId: Int, itemName: String) {
        cartViewModel.addToCart(itemId, itemName)
        Toast.makeText(context, "Item is added to cart", Toast.LENGTH_SHORT).show()
    }

    private fun addToFavorites(itemId: Int, itemName: String) {
        favouritesViewModel.addToFavourites(itemId, itemName)
        Toast.makeText(context, "Item is added to favorites", Toast.LENGTH_SHORT).show()
    }
}
