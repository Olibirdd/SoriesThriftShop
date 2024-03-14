package com.ferrer.johnoliver.block1.project.soriesthriftshop
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CartViewModel : ViewModel() {

    private val _cartItems = MutableLiveData<MutableList<String>>()
    val cartItems: LiveData<MutableList<String>> = _cartItems

    private val _cartItemCount = MutableLiveData<Int>()
    val cartItemCount: LiveData<Int> = _cartItemCount

    init {
        _cartItems.value = mutableListOf()
        _cartItemCount.value = 0
    }

    fun addToCart(itemName: String) {
        // Add the new item to the list of items
        val updatedList = _cartItems.value ?: mutableListOf()
        updatedList.add(itemName)
        _cartItems.value = updatedList

        // Increment the cart item count
        _cartItemCount.value = (_cartItemCount.value ?: 0) + 1
    }
}



