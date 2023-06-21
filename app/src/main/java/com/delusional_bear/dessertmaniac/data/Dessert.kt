package com.delusional_bear.dessertmaniac.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * [Dessert] data class to represent a dessert
 */

class Dessert(
    @StringRes val dessertName: Int,
    @DrawableRes val dessertImage: Int,
    @StringRes val ingredients: List<Int>,
    val rating: Double,
    val price: String,
    val totalNumberOfOrders: Int = 0,
)
