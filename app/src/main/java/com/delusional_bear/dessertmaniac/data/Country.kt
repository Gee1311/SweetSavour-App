package com.delusional_bear.dessertmaniac.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Country(
    @StringRes val countryName: Int,
    @DrawableRes val countryImage: Int = 0,
)
