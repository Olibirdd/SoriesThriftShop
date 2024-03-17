package com.ferrer.johnoliver.block1.project.soriesthriftshop
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.ferrer.johnoliver.block1.project.soriesthriftshop.CartViewModel
import com.ferrer.johnoliver.block1.project.soriesthriftshop.R

class CartAdapter(private val context: Context, private val items: MutableList<CartViewModel.Item>) : BaseAdapter() {

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): CartViewModel.Item = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        val holder: ViewHolder

        if (view == null) {
            // Inflate the cart item layout instead of fragment_cart.xml
            view = LayoutInflater.from(context).inflate(R.layout.cart_item_layout, parent, false)
            holder = ViewHolder()
            holder.itemNameTextView = view.findViewById(R.id.itemNameTextView)
            holder.itemImageView = view.findViewById(R.id.itemImageView)
            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }

        val currentItem = items[position]
        holder.itemNameTextView.text = currentItem.itemName
        holder.itemImageView.setImageResource(currentItem.itemImageResourceId)

        return view!!
    }

    private class ViewHolder {
        lateinit var itemNameTextView: TextView
        lateinit var itemImageView: ImageView
    }
}

