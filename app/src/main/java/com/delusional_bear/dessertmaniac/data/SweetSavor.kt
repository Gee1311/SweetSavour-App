package com.delusional_bear.dessertmaniac.data

import androidx.annotation.StringRes
import com.delusional_bear.dessertmaniac.R

/**
 * [SweetSavor] enum class represents the titles of different app's screens
 */
enum class SweetSavor(@StringRes val title: Int) {
    Home(title = R.string.app_name),
    Continent(title = R.string.continent),
    Country(title = R.string.country),
    Profile(title = R.string.profile),
    Desserts(title = R.string.desserts),
    Favorites(title = R.string.favorites),
    Cart(title = R.string.shopping_cart),
    PersonalData(title = R.string.personal_data),
    Balance(title = R.string.balance),
    Order(title = R.string.order),
    TopUpBalance(title = R.string.top_up_balance),
}