package com.delusional_bear.dessertmaniac.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.model.DataSource
import com.delusional_bear.dessertmaniac.ui.common_functions.displayToastMessage
import com.delusional_bear.dessertmaniac.ui.elements.pagers.DessertsLazyRow
import com.delusional_bear.dessertmaniac.ui.sweetsavor.SweetSavorViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    sweetSavorViewModel: SweetSavorViewModel,
) {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
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
            onAddToCartButtonClick = {
                coroutineScope.launch {
                    delay(500L)
                    sweetSavorViewModel.addToCart(it)
                    displayToastMessage(context, R.string.dessert_added_to_cart, Toast.LENGTH_SHORT)
                }
            },
        ) {
            sweetSavorViewModel.addToFavorites(it)
        }
    }
}