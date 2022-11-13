package ru.sample.store.denis.model

data class DataCardBestSeller(
    val picture: Int,
    val title: String,
    val price: String,
    val discountPrice: String,
    var favorite: Boolean = false
)
