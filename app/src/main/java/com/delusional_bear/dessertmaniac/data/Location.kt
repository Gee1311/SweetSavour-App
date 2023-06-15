package com.delusional_bear.dessertmaniac.data

import androidx.annotation.StringRes
import com.google.android.gms.maps.model.LatLng

/** [Location] is a data class which represents a country's exact location of the shop */

data class Location(
    @StringRes val locationName: Int,
    @StringRes val locationAddress: Int,
    val rating: Double,
    val isClosed: Boolean,
    val reviews: Int,
    val opensAt: String,
    val closesAt: String,
    val country: Country,
    val latLng: LatLng,
)
