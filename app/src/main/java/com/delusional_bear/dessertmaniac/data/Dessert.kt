package com.delusional_bear.dessertmaniac.data

import androidx.annotation.StringRes

/**
 * [Dessert] data class to represent a dessert
 */

data class Dessert(
    val id: Int,
    @StringRes val dessertName: Int,
    val dessertImageURL: String,
    @StringRes val ingredients: List<Int>,
    val rating: Double,
    val price: Double,
    val totalNumberOfOrders: Int = 0,
    val description: Int = 0,
)
