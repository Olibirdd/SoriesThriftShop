package com.ferrer.johnoliver.block1.project.soriesthriftshop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CartViewModel : ViewModel() {

    data class Item(val itemName: String, val itemImageResourceId: Int, var isCheckedOut: Boolean = false)

    private val _cartItems = MutableLiveData<List<Item>>()
    val cartItems: LiveData<List<Item>> = _cartItems

    private val _checkedOutItems = MutableLiveData<List<Item>>()
    val checkedOutItems: LiveData<List<Item>> = _checkedOutItems
    private val _cartItemCount = MutableLiveData<Int>()
    val cartItemCount: LiveData<Int> = _cartItemCount

    init {
        _cartItems.value = emptyList()
        _checkedOutItems.value = emptyList()
    }

    fun addToCart(itemImageResourceId: Int, itemName: String) {
        val updatedList = (_cartItems.value ?: emptyList()).toMutableList()
        updatedList.add(Item(itemName, itemImageResourceId))
        _cartItems.value = updatedList
    }

    fun removeFromCart(itemName: String) {
        val updatedList = (_cartItems.value ?: emptyList()).toMutableList()
        updatedList.removeAll { it.itemName == itemName }
        _cartItems.value = updatedList
    }

    fun markAsCheckedOut(itemName: String) {
        val updatedList = (_cartItems.value ?: emptyList()).toMutableList()
        val checkedOutList = (_checkedOutItems.value ?: emptyList()).toMutableList()

        updatedList.forEach { item ->
            if (item.itemName == itemName) {
                item.isCheckedOut = true
                checkedOutList.add(item)
            }
        }

        _cartItems.value = updatedList
        _checkedOutItems.value = checkedOutList
    }

    fun checkoutItems() {
        val itemsToCheckout = _cartItems.value ?: emptyList()
        itemsToCheckout.forEach { item ->
            if (!item.isCheckedOut) {
                item.isCheckedOut = true
            }
        }
        _cartItems.value = itemsToCheckout
    }
    fun removeFromCart(itemNames: List<String>) {
        val updatedList = (_cartItems.value ?: emptyList()).toMutableList()
        updatedList.removeAll { itemNames.contains(it.itemName) }
        _cartItems.value = updatedList
        _cartItemCount.value = (_cartItemCount.value ?: 0) - itemNames.size
    }

}
