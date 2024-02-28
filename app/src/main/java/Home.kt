package com.ferrer.johnoliver.block1.project.soriesthriftshop

data class HomeContent(
    val title: String,
    val description: String,
    // Add any other properties you want to include in the home content
)

fun getHomeContent(): HomeContent {
    return HomeContent(
        title = "Welcome to the Sories Thrift Shop!",
        description = "Here you can find the best deals on second-hand items. Shop now and save money!",
        // Add any other properties you want to include in the home content
    )
}