package com.delusional_bear.dessertmaniac.ui.sweetsavor

import com.delusional_bear.dessertmaniac.data.Country
import com.delusional_bear.dessertmaniac.data.Dessert
import com.delusional_bear.dessertmaniac.data.model.DataSource

data class SweetUiState(
    val isDessertAvailable: Boolean = false,
    val continent: Int = 0,
    val countries: Map<Int, List<Country>> = DataSource.countryList.groupBy { it.continentName },
    val favoriteDesserts: MutableSet<Dessert> = mutableSetOf(),
    val cartDesserts: MutableSet<Dessert> = mutableSetOf(),
    val dessertCount: Int = 1,
    val subTotal: Double = 0.0,
    val shipping: Double = 2.99,
    val discount: Double = 0.0,
    val balance: Double = 0.0,
    val orders: Int = 0,
    val totalItems: Int = 0,
    val date: String = "",
    val paymentMethod: Int = 0,
    val isSignOutDialogOpened: Boolean = false,
    val isFavoriteDialogOpened: Boolean = false,
)
