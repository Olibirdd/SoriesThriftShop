package com.ferrer.johnoliver.block1.project.soriesthriftshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.ferrer.johnoliver.block1.project.soriesthriftshop.databinding.FragmentVintageBinding

class VintageFragment : Fragment() {

    private lateinit var binding: FragmentVintageBinding
    private val favouritesViewModel: FavouritesViewModel by activityViewModels()
    private val cartViewModel: CartViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVintageBinding.inflate(inflater, container, false)
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
                addToFavorites(itemId,itemName)
            }
        }

        return binding.root
    }

    private fun getImageNameForItemId(buttonId: Int): String {
        return when (buttonId) {
            R.id.add -> "Bonnie Blouse Cream"
            R.id.add1 -> "Cardigan Croptop"
            R.id.add2 -> "Cider Lapel Halter Dress"
            R.id.add3 -> "Croptop Sweater"
            R.id.add4 -> "Wool Turtle Neck Sweater"
            R.id.add5 -> "Floral Puff Sleeve Dress"
            R.id.add6 -> "Gucci Tweed Dress"
            R.id.add7 -> "Simone Rocha Cardigan"
            R.id.add9 -> "Knit Polo Croptop"
            R.id.add10 -> "Pin Stripe Longsleeve"
            R.id.add11 -> "Plaid Dress"
            R.id.add12 -> "Polo Dress"
            R.id.add13 -> "Polka Dot Dress"
            R.id.add14 -> "Milly Micro Striped Dress"
            R.id.add15 -> "Lantern Long Sleeve"
            R.id.add16 -> "Polo Shirt"
            R.id.add17 -> "Short Denim Jumpsuit"
            R.id.add18 -> "V-Neck Blouse Croptop"
            R.id.add19 -> "Tie Front Trim Flouce Sleeve"
            R.id.add20 -> "Woven Vest"
            R.id.fav -> "Bonnie Blouse Cream"
            R.id.fav1 -> "Cardigan Croptop"
            R.id.fav2 -> "Cider Lapel Halter Dress"
            R.id.fav3 -> "Croptop Sweater"
            R.id.fav4 -> "Wool Turtle Neck Sweater"
            R.id.fav5 -> "Floral Puff Sleeve Dress"
            R.id.fav6 -> "Gucci Tweed Dress"
            R.id.fav7 -> "Simone Rocha Cardigan"
            R.id.fav9 -> "Knit Polo Croptop"
            R.id.fav10 -> "Pin Stripe Longsleeve"
            R.id.fav11 -> "Plaid Dress"
            R.id.fav12 -> "Polo Dress"
            R.id.fav13 -> "Polka Dot Dress"
            R.id.fav14 -> "Milly Micro Striped Dress"
            R.id.fav15 -> "Lantern Long Sleeve"
            R.id.fav16 -> "Polo Shirt"
            R.id.fav17 -> "Short Denim Jumpsuit"
            R.id.fav18 -> "V-Neck Blouse Croptop"
            R.id.fav19 -> "Tie Front Trim Flouce Sleeve"
            R.id.fav20 -> "Woven Vest"
            else -> "Unknown Item"
        }
    }

    private fun getImageIdForItem(itemName: String): Int {
        val imageIdMap = mapOf(
            "Bonnie Blouse Cream" to R.drawable.bonnie_blouse_cream,
            "Cardigan Croptop" to R.drawable.cardigan_croptop,
            "Cider Lapel Halter Dress" to R.drawable.cider_disty_lapel_halter_dress,
            "Croptop Sweater" to R.drawable.croptop_sweater,
            "Wool Turtle Neck Sweater" to R.drawable.cropped_wool_turtleneck_sweater,
            "Floral Puff Sleeve Dress" to R.drawable.floral_puff_sleeve_boho_midi_dress,
            "Gucci Tweed Dress" to R.drawable.gucci_tweed_dress,
            "Simone Rocha Cardigan" to R.drawable.simone_rocha_cropped_knitted_cardigan,
            "Knit Polo Croptop" to R.drawable.knit_polo_croptop,
            "Pin Stripe Longsleeve" to R.drawable.pin_stripe_longsleeve_blouse,
            "Plaid Dress" to R.drawable.plaid_dress,
            "Polo Dress" to R.drawable.polo_dress,
            "Polka Dot Dress" to R.drawable.polka_dot_dress,
            "Milly Micro Striped Dress" to R.drawable.milly_micro_striped_flare_dress,
            "Lantern Long Sleeve" to R.drawable.lantern_long_sleeve,
            "Polo Shirt" to R.drawable.polo_shirt,
            "Short Denim Jumpsuit" to R.drawable.short_denim_jumsuit,
            "V-Neck Blouse Croptop" to R.drawable.v_neck_blouse_croptop,
            "Tie Front Trim Flouce Sleeve" to R.drawable.tie_front_lettuce_trim_flouce_sleeve_top,
            "Woven Vest" to R.drawable.woven_vest
        )
        return imageIdMap[itemName] ?: R.drawable.ic_person // Return default if no mapping found
    }

    private fun addToCart(itemId: Int, itemName: String) {
        cartViewModel.addToCart(itemId, itemName)
        Toast.makeText(context, "Item is added to cart", Toast.LENGTH_SHORT).show()
    }

    private fun addToFavorites(itemId: Int,itemName: String) {
        favouritesViewModel.addToFavourites(itemId,itemName)
        Toast.makeText(context, "Item is added to favorites", Toast.LENGTH_SHORT).show()
    }
}
