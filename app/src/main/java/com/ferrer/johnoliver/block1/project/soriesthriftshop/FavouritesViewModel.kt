package com.ferrer.johnoliver.block1.project.soriesthriftshop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Log

class FavouritesViewModel : ViewModel() {

    data class Item(val itemName: String, val itemImageResourceId: Int)

    private val _favouriteItems = MutableLiveData<MutableList<Item>>()
    val favouriteItems: LiveData<MutableList<Item>> get() = _favouriteItems

    private val _favouritesCount = MutableLiveData<Int>()
    val favouritesCount: LiveData<Int> get() = _favouritesCount

    init {
        _favouriteItems.value = mutableListOf()
        _favouritesCount.value = 0
    }

    fun addToFavourites(itemImageResourceId: Int, itemName: String) {
        Log.d("FavouritesViewModel", "Adding item to favourites: $itemName with image resource ID: $itemImageResourceId")

        val updatedList = _favouriteItems.value ?: mutableListOf()
        updatedList.add(Item(itemName, itemImageResourceId))
        _favouriteItems.value = updatedList

        _favouritesCount.value = (_favouritesCount.value ?: 0) + 1
    }
}


