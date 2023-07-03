package com.delusional_bear.dessertmaniac.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.model.DataSource
import com.delusional_bear.dessertmaniac.ui.sweetsavor.SweetSavorViewModel
import com.delusional_bear.dessertmaniac.ui.sweetsavor.SweetUiState
import com.delusional_bear.dessertmaniac.ui.elements.pagers.DessertsLazyRow
import com.delusional_bear.dessertmaniac.ui.elements.textfields.SearchDessertTextField
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme
import kotlin.random.Random

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    sweetSavorViewModel: SweetSavorViewModel,
    sweetUiState: SweetUiState,
) {
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_small))
    ) {
        SearchDessertTextField(
            sweetSavorViewModel = sweetSavorViewModel,
            keyboardActions = KeyboardActions(
                onDone = {
                    sweetSavorViewModel.checkAvailability(
                        focusManager = focusManager,
                        context = context,
                    )
                }
            ),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            isDessertAvailable = sweetUiState.isDessertAvailable,
        )
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
                sweetSavorViewModel.addToCart(it)
            }
        ) {
            sweetSavorViewModel.addToFavorites(it)
        }
    }
}

@Preview
@Composable
private fun StartScreenLightThemePreview() {
    DessertManiacTheme {
        HomeScreen(
            sweetSavorViewModel = SweetSavorViewModel(),
            sweetUiState = SweetUiState()
        )
    }
}
@Preview
@Composable
private fun StartScreenDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        HomeScreen(
            sweetSavorViewModel = SweetSavorViewModel(),
            sweetUiState = SweetUiState()
        )
    }
}