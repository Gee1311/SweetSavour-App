package com.delusional_bear.dessertmaniac.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Dessert
import com.delusional_bear.dessertmaniac.ui.elements.cards.AvailableDessertCard

@Composable
fun AvailableDessertsScreen(
    dessertList: List<Dessert>,
    modifier: Modifier = Modifier,
    onFavoriteClick: (Dessert) -> Unit = {},
    onCartClick: (Dessert) -> Unit = {},
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(220.dp),
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
    ) {
        items(dessertList) { dessert ->
            AvailableDessertCard(
                dessert = dessert,
                onFavoriteClick = { onFavoriteClick(dessert) },
            ) { onCartClick(dessert) }
        }
    }
}