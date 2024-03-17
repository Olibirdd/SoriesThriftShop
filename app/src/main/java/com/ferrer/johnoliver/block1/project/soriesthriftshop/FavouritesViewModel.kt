package com.ferrer.johnoliver.block1.project.soriesthriftshop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Log

class FavouritesViewModel : ViewModel() {

    // Define the Item class with itemName as String and itemImageResourceId as Int
    data class Item(val itemName: String, val itemImageResourceId: Int)

    private val _favouriteItems = MutableLiveData<MutableList<Item>>()
    val favouriteItems: LiveData<MutableList<Item>> get() = _favouriteItems

    private val _favouritesCount = MutableLiveData<Int>()
    val favouritesCount: LiveData<Int> get() = _favouritesCount

    init {
        _favouriteItems.value = mutableListOf()
        _favouritesCount.value = 0
    }

    // Modified function to add an item to the favourites with its ID and name
    fun addToFavourites(itemImageResourceId: Int, itemName: String) {
        // Add logging to debug the issue
        Log.d("FavouritesViewModel", "Adding item to favourites: $itemName with image resource ID: $itemImageResourceId")

        // Add the new item to the list of items
        val updatedList = _favouriteItems.value ?: mutableListOf()
        updatedList.add(Item(itemName, itemImageResourceId))
        _favouriteItems.value = updatedList

        // Increment the favourites count
        _favouritesCount.value = (_favouritesCount.value ?: 0) + 1
    }
}


