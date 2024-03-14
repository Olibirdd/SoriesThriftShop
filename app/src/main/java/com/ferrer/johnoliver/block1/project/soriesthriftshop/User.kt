package com.ferrer.johnoliver.block1.project.soriesthriftshop

class User {
    data class User(
        val username: String,
        var cartItemsCount: Int = 0,
        var favoritesCount: Int = 0
    )

}