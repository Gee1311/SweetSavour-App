package com.delusional_bear.dessertmaniac.ui.elements.lists

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.MostOrderedDessert
import com.delusional_bear.dessertmaniac.ui.elements.cards.MostOrderedCard

@Composable
fun MostOrderedList(
    mostOrderedList: List<MostOrderedDessert>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
    ) {
        items(mostOrderedList) { mostOrderedDessert ->
            MostOrderedCard(dessert = mostOrderedDessert)
        }
    }
}