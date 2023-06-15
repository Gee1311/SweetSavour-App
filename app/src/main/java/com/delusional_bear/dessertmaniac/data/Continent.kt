package com.delusional_bear.dessertmaniac.data

import androidx.annotation.StringRes

data class Continent(
    @StringRes val continentName: Int,
    val countries: Set<Int>,
    val availableShops: Int,
)
