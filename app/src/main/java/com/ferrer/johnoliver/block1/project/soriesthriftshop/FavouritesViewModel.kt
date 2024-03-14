package com.ferrer.johnoliver.block1.project.soriesthriftshop
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavouritesViewModel : ViewModel() {

    private val _items = MutableLiveData<List<String>>()
    val items: LiveData<List<String>> get() = _items

    private val _favoritesCount = MutableLiveData<Int>()
    val favoritesCount: LiveData<Int> get() = _favoritesCount

    init {
        _items.value = mutableListOf()
        _favoritesCount.value = 0
    }

    fun addToFavorites(itemName: String) {
        // Add the new item to the list of items
        val updatedList = _items.value?.toMutableList() ?: mutableListOf()
        updatedList.add(itemName)
        _items.value = updatedList

        // Increment the favorites count
        _favoritesCount.value = (_favoritesCount.value ?: 0) + 1
    }
}


