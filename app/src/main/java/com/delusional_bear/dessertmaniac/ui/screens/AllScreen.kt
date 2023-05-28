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
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Dessert
import com.delusional_bear.dessertmaniac.model.DataSource
import com.delusional_bear.dessertmaniac.ui.elements.DessertCard
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AllScreen(
    listOfDesserts: List<Dessert>,
    modifier: Modifier = Modifier,
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalItemSpacing = 16.dp,
    ) {
        items(listOfDesserts) { dessert -> DessertCard(dessert = dessert) }
    }
}

@Preview
@Composable
private fun AllScreenLightThemePreview() {
    DessertManiacTheme {
        AllScreen(listOfDesserts = DataSource.dessertList)
    }
}
@Preview
@Composable
private fun AllScreenDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        AllScreen(listOfDesserts = DataSource.dessertList)
    }
}