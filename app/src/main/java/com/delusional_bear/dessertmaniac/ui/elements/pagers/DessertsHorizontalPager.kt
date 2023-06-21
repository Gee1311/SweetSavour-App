package com.delusional_bear.dessertmaniac.ui.elements.pagers

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.delusional_bear.dessertmaniac.data.Dessert
import com.delusional_bear.dessertmaniac.data.model.DataSource
import com.delusional_bear.dessertmaniac.ui.elements.cards.MostOrderedDessertCard
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DessertsHorizontalPager(
    dessertList: List<Dessert>,
    modifier: Modifier = Modifier,
) {
    HorizontalPager(
        pageCount = dessertList.size,
        modifier = modifier,
        pageContent = { index ->
            MostOrderedDessertCard(dessert = dessertList[index])
        }
    )
}

@Preview
@Composable
private fun DessertsHorizontalPagerLightThemePreview() {
    DessertManiacTheme {
        DessertsHorizontalPager(dessertList = DataSource.dessertList)
    }
}

@Preview
@Composable
private fun DessertsHorizontalPagerDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        DessertsHorizontalPager(dessertList = DataSource.dessertList)
    }
}