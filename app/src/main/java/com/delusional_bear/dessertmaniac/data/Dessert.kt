package com.delusional_bear.dessertmaniac.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * [Dessert] data class to represent a dessert
 */

data class Dessert(
    @StringRes val dessertName: Int,
    @DrawableRes val dessertImage: Int,
    @StringRes val ingredients: List<Int>,
    val rating: Double,
    val preparationTime: Int = 0,
    val cookTime: Int = 0,
    val nutrition: List<Pair<String, Int>> = emptyList()
)
