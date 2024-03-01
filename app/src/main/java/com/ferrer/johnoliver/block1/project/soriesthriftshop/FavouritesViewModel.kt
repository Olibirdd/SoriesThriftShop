package com.ferrer.johnoliver.block1.project.soriesthriftshop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class FavouritesViewModel : ViewModel() {

    private val _items = MutableLiveData<List<String>>()
    val items: LiveData<List<String>> get() = _items

    init {
        _items.value = mutableListOf()
    }

    fun addToFavorites(itemName: String) {
        // Add the new item to the list of items
        val updatedList = _items.value?.toMutableList() ?: mutableListOf()
        updatedList.add(itemName)
        _items.value = updatedList
    }
}

