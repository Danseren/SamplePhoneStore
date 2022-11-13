package ru.sample.store.denis.model

data class DataCardHotSales (
    val picture: Int,
    var newStatus: Boolean = false,
    val title: String,
    val subtitle: String,
)