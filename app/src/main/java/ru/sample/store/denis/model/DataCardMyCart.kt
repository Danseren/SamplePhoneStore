package ru.sample.store.denis.model

import ru.sample.store.denis.R

data class DataCardMyCart(
    val picture: Int = R.drawable.samsung_note_20_ultra,
    val title: String = "Samsung Note 20 Ultra",
    val price: String = "$3,000.00"
)