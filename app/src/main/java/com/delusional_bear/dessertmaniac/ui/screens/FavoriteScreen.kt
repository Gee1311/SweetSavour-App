package com.delusional_bear.dessertmaniac.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.ui.elements.cards.FavoriteCard
import com.delusional_bear.dessertmaniac.ui.sweetsavor.SweetUiState
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FavoriteScreen(
    uiState: SweetUiState,
    modifier: Modifier = Modifier,
) {
    LazyVerticalStaggeredGrid(
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_large)),
        columns = StaggeredGridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
        verticalItemSpacing = dimensionResource(id = R.dimen.padding_small)
    ) {
        items(uiState.favoriteDesserts.toList()) { dessert ->
            FavoriteCard(dessert = dessert)
        }
    }
}

@Preview
@Composable
fun FavoriteScreenLightThemePreview() {
    DessertManiacTheme() {
        FavoriteScreen(uiState = SweetUiState())
    }
}

@Preview
@Composable
fun FavoriteScreenDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        FavoriteScreen(uiState = SweetUiState())
    }
}
