package com.delusional_bear.dessertmaniac.ui.elements.pagers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Dessert
import com.delusional_bear.dessertmaniac.data.model.DataSource
import com.delusional_bear.dessertmaniac.ui.elements.cards.MostOrderedDessertCard
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@Composable
fun DessertsLazyRow(
    dessertList: List<Dessert>,
    modifier: Modifier = Modifier,
    onAddToCartButtonClick: (Dessert) -> Unit = {},
    onLikeButtonClick: (Dessert) -> Unit = {},
) {
    LazyRow(
        modifier = modifier.height(400.dp),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
    ) {
        items(dessertList) { dessert ->
            MostOrderedDessertCard(
                dessert = dessert,
                onLikeButtonClick = { onLikeButtonClick.invoke(dessert) }
            ) {
                onAddToCartButtonClick.invoke(dessert)
            }
        }
    }
}

@Preview
@Composable
private fun DessertsHorizontalPagerLightThemePreview() {
    DessertManiacTheme {
        DessertsLazyRow(dessertList = DataSource.dessertList)
    }
}

@Preview
@Composable
private fun DessertsHorizontalPagerDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        DessertsLazyRow(dessertList = DataSource.dessertList)
    }
}