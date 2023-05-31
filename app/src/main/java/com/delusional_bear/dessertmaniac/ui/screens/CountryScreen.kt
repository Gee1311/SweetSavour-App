package com.delusional_bear.dessertmaniac.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Country
import com.delusional_bear.dessertmaniac.ui.elements.CountryCard

@Composable
fun CountryScreen(
    countryList: List<Country>,
    modifier: Modifier = Modifier,
    onUSClick: () -> Unit,
    onUkraineClick: () -> Unit,
) {
    Column(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))) {
        Text(
            text = stringResource(R.string.pick_up_your_country),
            style = MaterialTheme.typography.headlineMedium,
            modifier = modifier.padding(bottom = dimensionResource(id = R.dimen.padding_large)),
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
        ){
            items(countryList) { country ->
                when (country.countryName) {
                    R.string.united_states -> {
                        CountryCard(
                            country = country,
                            onCardClick = onUSClick,
                        )
                    }
                    R.string.ukraine -> {
                        CountryCard(
                            country = country,
                            onCardClick = onUkraineClick,
                        )
                    }
                }
            }
        }
    }
}