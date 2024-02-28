package com.ferrer.johnoliver.block1.project.soriesthriftshop
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CartViewModel : ViewModel() {

    private val _cartItems = MutableLiveData<MutableList<String>>()
    val cartItems: LiveData<MutableList<String>> = _cartItems

    init {
        _cartItems.value = mutableListOf()
    }

    fun addToCart(itemName: String) {
        val currentItems = _cartItems.value ?: mutableListOf()
        currentItems.add(itemName)
        _cartItems.value = currentItems
    }
}


