package com.ferrer.johnoliver.block1.project.soriesthriftshop
import android.content.Intent
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.ferrer.johnoliver.block1.project.soriesthriftshop.databinding.FragmentCartBinding
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer


class CartFragment : Fragment() {

    private lateinit var cartItemList: LinearLayout
    private lateinit var emptyCartTextView: TextView
    private lateinit var totalPriceTextView: TextView
    private lateinit var placeholderImage: ImageView
    private lateinit var checkoutButton: Button
    private lateinit var binding: FragmentCartBinding
    private val cartViewModel: CartViewModel by activityViewModels()
    private val checkoutViewModel: CheckoutViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        cartItemList = binding.cartItemList
        emptyCartTextView = binding.emptyCartTextView
        totalPriceTextView = binding.totalPriceTextView
        placeholderImage = binding.placeholderImage
        checkoutButton = binding.checkoutButton
        setupCartObserver()
        setupCheckoutButton()
        setupCheckoutObserver()
        return binding.root
    }

    private fun setupCartObserver() {
        cartViewModel.cartItems.observe(viewLifecycleOwner) { items ->
            cartItemList.removeAllViews()

            var totalPrice = 0.0

            items.forEach { item ->
                val itemView = LayoutInflater.from(context).inflate(R.layout.cart_item_layout, cartItemList, false)

                val itemNameTextView: TextView = itemView.findViewById(R.id.itemNameTextView)
                val itemImageView: ImageView = itemView.findViewById(R.id.itemImageView)
                val itemCheckBox: CheckBox = itemView.findViewById(R.id.itemCheckBox)
                itemNameTextView.text = item.itemName

                val imageResourceId = getImageIdForItem(item.itemName)
                itemImageView.setImageResource(imageResourceId)

                if (itemCheckBox.isChecked) {
                    totalPrice += getPriceForItem(item.itemName)
                }

                itemCheckBox.setOnCheckedChangeListener { _, isChecked ->
                    totalPrice = if (isChecked) {
                        totalPrice + getPriceForItem(item.itemName)
                    } else {
                        totalPrice - getPriceForItem(item.itemName)
                    }

                    totalPriceTextView.text = getString(R.string.total_price_format, totalPrice)
                }

                cartItemList.addView(itemView)
            }

            totalPriceTextView.text = getString(R.string.total_price_format, totalPrice)
        }
    }

    private fun setupCheckoutButton() {
        checkoutButton.setOnClickListener {
            val checkedItems = mutableListOf<CartViewModel.Item>()

            for (i in 0 until cartItemList.childCount) {
                val itemView = cartItemList.getChildAt(i)
                val itemCheckBox: CheckBox = itemView.findViewById(R.id.itemCheckBox)

                if (itemCheckBox.isChecked) {
                    val itemNameTextView: TextView = itemView.findViewById(R.id.itemNameTextView)
                    val itemName = itemNameTextView.text.toString()
                    val item = cartViewModel.cartItems.value?.find { it.itemName == itemName }
                    item?.let { checkedItems.add(it) }
                }
            }

            if (checkedItems.isEmpty()) {
                Toast.makeText(context, "No items selected for checkout.", Toast.LENGTH_SHORT).show()
            } else {
                binding.cartItemList.removeAllViews()

                val checkoutItemsLayout = LinearLayout(context)
                checkoutItemsLayout.orientation = LinearLayout.VERTICAL

                checkedItems.forEach { item ->
                    val itemNameTextView = TextView(context)
                    itemNameTextView.text = item.itemName
                    checkoutItemsLayout.addView(itemNameTextView)

                    // Increment checkedOutItemCount for each checked item
                    checkoutViewModel.incrementCheckedOutItemCount()
                }

                binding.cartItemList.addView(checkoutItemsLayout)

                checkedItems.forEach { cartViewModel.removeFromCart(it.itemName) }

                Toast.makeText(context, "Checkout successful. Checked items removed from cart.", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun setupCheckoutObserver() {
        checkoutViewModel.checkedOutItemCount.observe(viewLifecycleOwner, Observer {
        })
    }

    private fun getPriceForItem(itemName: String): Double {
        return when (itemName) {
            // Tops
            "Bonnie Blouse Cream" -> 120.00
            "Cardigan Croptop" -> 135.00
            "Cider Lapel Halter Dress" -> 150.00
            "Croptop Sweater" -> 165.00
            "Wool Turtle Neck Sweater" -> 180.00
            "Floral Puff Sleeve Dress" -> 195.00
            "Gucci Tweed Dress" -> 210.00
            "Simone Rocha Cardigan" -> 225.00
            "Knit Polo Croptop" -> 240.00
            "Pin Stripe Longsleeve" -> 255.00
            "Plaid Dress" -> 270.00
            "Polo Dress" -> 285.00
            "Polka Dot Dress" -> 300.00
            "Milly Micro Striped Dress" -> 120.00
            "Lantern Long Sleeve" -> 135.00
            "Polo Shirt" -> 150.00
            "Short Denim Jumpsuit" -> 165.00
            "V-Neck Blouse Croptop" -> 180.00
            "Tie Front Trim Flouce Sleeve" -> 195.00
            "Woven Vest" -> 210.00
            // Shorts
            "Balmin Cargo Short" -> 225.00
            "Button Decor High Waisted" -> 240.00
            "Cleopatra Stone Short" -> 255.00
            "Cotton Denim Short" -> 270.00
            "Denim Short with Belt" -> 285.00
            "Frill Waist Denim Short" -> 300.00
            "Plus Flap Pocket Cargo Short" -> 120.00
            "River Island High Waisted Knicker Short" -> 135.00
            "Inspired Shorts" -> 150.00
            "Vintage Vogue" -> 165.00
            "Classic Cutoffs" -> 180.00
            "Heritage Hemlines" -> 195.00
            "Casual Short" -> 210.00
            "Nostalgia Knickers" -> 225.00
            "OldSchool Chic Bottoms" -> 240.00
            "Rustic Retro Shorts" -> 255.00
            "Retro Revival Shorts" -> 270.00
            "Throwback Trunks" -> 285.00
            "Timeless Tailored Shorts" -> 300.00
            "Vintage Verve Shorts" -> 120.00
            // Pants
            "Baggy Pants" -> 135.00
            "Blue Pants with White Belt" -> 150.00
            "Classic Cutoffs" -> 165.00
            "Denim Jeans" -> 180.00
            "Cider Waist Tie Trouser" -> 195.00
            "Fly Solid Wide Leg Pants" -> 210.00
            "High Waist Baggy Pants" -> 225.00
            "High Waist Pants" -> 240.00
            "High Waisted Wide Leg Trouser" -> 255.00
            "Hight Waist Pants" -> 270.00
            "Jogging Pants" -> 285.00
            "Antique Denim Dungerees" -> 300.00
            "Retro Low Waist Jeans" -> 120.00
            "Super High Waisted Button Front Wide Leg" -> 135.00
            "Trouser" -> 150.00
            "Classic Corduroy" -> 165.00
            "Nostalgic High Waisted" -> 180.00
            "Retro Flare Trousers" -> 195.00
            "Timeless Tweed" -> 210.00
            "Vintage Velvet" -> 225.00

            else -> 0.0 // Default price
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
        return imageIdMap[itemName] ?: R.drawable.ic_person
    }

}
