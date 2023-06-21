package com.delusional_bear.dessertmaniac.ui.elements.pagers

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.delusional_bear.dessertmaniac.data.Dessert
import com.delusional_bear.dessertmaniac.ui.elements.cards.AvailableDessertCard

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DessertsVerticalPager(
    dessertsList: List<Dessert>,
    modifier: Modifier = Modifier,
) {
    VerticalPager(
        pageCount = dessertsList.size,
        pageContent = { index ->
            AvailableDessertCard(dessert = dessertsList[index])
        },
        modifier = modifier,
    )
}