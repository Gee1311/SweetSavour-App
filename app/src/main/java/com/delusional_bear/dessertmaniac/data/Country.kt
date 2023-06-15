package com.delusional_bear.dessertmaniac.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/** [Country] is a data class that represents a country in which shops are available */

data class Country(
    @StringRes val continentName: Int,
    @StringRes val countryName: Int,
    @DrawableRes val countryImage: Int = 0,
)
