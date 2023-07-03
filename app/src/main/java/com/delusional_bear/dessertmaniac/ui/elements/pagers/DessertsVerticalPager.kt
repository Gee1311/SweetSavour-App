package com.delusional_bear.dessertmaniac.ui.elements.pagers

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.delusional_bear.dessertmaniac.data.Dessert
import com.delusional_bear.dessertmaniac.ui.sweetsavor.SweetSavorViewModel
import com.delusional_bear.dessertmaniac.ui.elements.cards.AvailableDessertCard

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DessertsVerticalPager(
    dessertsList: List<Dessert>,
    context: Context,
    modifier: Modifier = Modifier,
    pageSpacing: Dp,
    viewModel: SweetSavorViewModel,
) {
    VerticalPager(
        pageCount = dessertsList.size,
        pageContent = { index ->
            AvailableDessertCard(
                dessert = dessertsList[index],
                onLikeButtonClick = { viewModel.addToFavorites(dessert = dessertsList[index]) },
                context = context
            ) {
                viewModel.addToCart(dessert = dessertsList[index])
            }
        },
        modifier = modifier,
        pageSpacing = pageSpacing,
    )
}