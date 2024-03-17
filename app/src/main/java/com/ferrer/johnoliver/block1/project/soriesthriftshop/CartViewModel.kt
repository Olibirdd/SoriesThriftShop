package com.ferrer.johnoliver.block1.project.soriesthriftshop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Log

class CartViewModel : ViewModel() {

    // Define the Item class with itemName as String and itemImageResourceId as Int
    data class Item(val itemName: String, val itemImageResourceId: Int)

    private val _cartItems = MutableLiveData<MutableList<Item>>()
    val cartItems: LiveData<MutableList<Item>> = _cartItems

    private val _cartItemCount = MutableLiveData<Int>()
    val cartItemCount: LiveData<Int> = _cartItemCount

    init {
        _cartItems.value = mutableListOf()
        _cartItemCount.value = 0
    }

    // Modified function to add an item to the cart with its ID and name
    fun addToCart(itemImageResourceId: Int, itemName: String) {
        // Add logging to debug the issue
        Log.d("CartViewModel", "Adding item to cart: $itemName with image resource ID: $itemImageResourceId")

        // Add the new item to the list of items
        val updatedList = _cartItems.value ?: mutableListOf()
        updatedList.add(Item(itemName, itemImageResourceId))
        _cartItems.value = updatedList

        // Increment the cart item count
        _cartItemCount.value = (_cartItemCount.value ?: 0) + 1
    }
}

