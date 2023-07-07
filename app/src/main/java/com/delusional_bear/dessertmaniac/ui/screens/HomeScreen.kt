package com.delusional_bear.dessertmaniac.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.model.DataSource
import com.delusional_bear.dessertmaniac.ui.elements.pagers.DessertsLazyRow
import com.delusional_bear.dessertmaniac.ui.sweetsavor.SweetSavorViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    sweetSavorViewModel: SweetSavorViewModel,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_small))
    ) {
        Text(
            text = stringResource(id = R.string.most_ordered),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_medium))
        )
        DessertsLazyRow(
            dessertList = DataSource.dessertList
                .filter { it.totalNumberOfOrders >= 650 }
                .sortedByDescending { it.totalNumberOfOrders },
            onAddToCartButtonClick = { sweetSavorViewModel.addToCart(it) },
        ) {
            sweetSavorViewModel.addToFavorites(it)
        }
    }
}
