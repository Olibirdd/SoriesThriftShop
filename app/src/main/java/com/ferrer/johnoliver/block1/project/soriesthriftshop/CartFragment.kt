package com.ferrer.johnoliver.block1.project.soriesthriftshop
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.ferrer.johnoliver.block1.project.soriesthriftshop.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    private lateinit var cartItemList: LinearLayout
    private lateinit var binding: FragmentCartBinding
    private val cartViewModel: CartViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        cartItemList = binding.cartItemList // Reference the LinearLayout
        setupCartObserver(cartItemList) // Pass the cartItemList LinearLayout as the parent ViewGroup here
        return binding.root
    }


    private fun setupCartObserver(parent: ViewGroup) {
        cartViewModel.cartItems.observe(viewLifecycleOwner) { items ->
            // Clear the existing views before adding new ones
            cartItemList.removeAllViews()
            items.forEach { item ->
                val itemView = LayoutInflater.from(context).inflate(R.layout.cart_item_layout, parent, false)

                // Bind data to views within the item layout
                val itemNameTextView: TextView = itemView.findViewById(R.id.itemNameTextView)
                val itemImageView: ImageView = itemView.findViewById(R.id.itemImageView)
                itemNameTextView.text = item.itemName

                // Set item image here
                val imageResourceId = getImageIdForItem(item.itemName)
                itemImageView.setImageResource(imageResourceId)

                cartItemList.addView(itemView)
            }
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
            "Woven Vest" to R.drawable.woven_vest,
            //short
            "Balmin Cargo Short" to R.drawable.balmin_cargo_short,
            "Button Decor High Waisted" to R.drawable.button_decor_high_waist_short,
            "Cleopatra Stone Short" to R.drawable.cleopatra_stone_short,
            "Cotton Denim Short" to R.drawable.cotton_denim_short,
            "Denim Short with Belt" to R.drawable.denim_short_with_belt,
            "Frill Waist Denim Short" to R.drawable.frill_waist_denim_short,
            "Plus Flap Pocket Cargo Short" to R.drawable.plus_flap_pocket_cargo_short,
            "River Island High Waisted Short" to R.drawable.river_island_high_waisted_knicker_short,
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
            "Vintage Verve Shorts" to R.drawable.vintage_verve_shorts,
            //pants
            "Baggy Pants" to R.drawable.baggy_pants,
            "Blue Pants with White Belt" to R.drawable.blue_pants_with_white_belt,
            "Classic Cutoffs" to R.drawable.classic_cutoffs,
            "Denim Jeans" to R.drawable.denim_jeans,
            "Cider Waist Tie Trouser" to R.drawable.cider_waist_tie_trouser,
            "Fly Solid Wide Leg Pants" to R.drawable.fly_solid_wide_leg_pants,
            "High Waist Baggy Pants" to R.drawable.high_waist_baggy_pants,
            "Wide Leg Trouser" to R.drawable.high_waisted_wide_leg_trouser,
            "High Waist Pants" to R.drawable.high_waist_pants,
            "Jogging Pants" to R.drawable.jogging_pants,
            "Antique Denim Dumgerees" to R.drawable.antique_denim_dungerees,
            "Retro Low Waist Jeans" to R.drawable.retro_low_waist_jeans,
            "Super High Waisted Button" to R.drawable.super_high_waisted_button_front_wide_leg,
            "Trouser" to R.drawable.trouser,
            "Classic Corduroy" to R.drawable.classic_corduroy,
            "Nostalgic High Waisted" to R.drawable.nostalgic_high_waisted,
            "Retro Flare Trousers" to R.drawable.retro_flare_trousers,
            "Timeless Tweed" to R.drawable.timeless_tweed,
            "Vintage Velvet" to R.drawable.vintage_velvet,
            "Wide Leg Trouser" to R.drawable.high_waisted_wide_leg_trouser,
        )
        return imageIdMap[itemName] ?: R.drawable.ic_person // Return default if no mapping found
    }

}
