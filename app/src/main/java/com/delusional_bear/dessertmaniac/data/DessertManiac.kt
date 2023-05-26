package com.delusional_bear.dessertmaniac.data

import androidx.annotation.StringRes
import com.delusional_bear.dessertmaniac.R

enum class DessertManiac(@StringRes val title: Int) {
    TopMostRated(title = R.string.top_most_rated),
    TopMostPopular(title = R.string.top_most_rated),
    TopWorstRated(title = R.string.top_worst_rated),
    All(title = R.string.all_desserts),
    Start(title = R.string.app_name),
}