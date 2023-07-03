package com.delusional_bear.dessertmaniac.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Dessert
import com.delusional_bear.dessertmaniac.data.model.DataSource
import com.delusional_bear.dessertmaniac.ui.elements.pagers.DessertsVerticalPager
import com.delusional_bear.dessertmaniac.ui.sweetsavor.SweetSavorViewModel
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@Composable
fun AvailableDessertsScreen(
    listOfDesserts: List<Dessert>,
    modifier: Modifier = Modifier,
    viewModel: SweetSavorViewModel,
) {
    val context = LocalContext.current
    DessertsVerticalPager(
        dessertsList = listOfDesserts,
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium)),
        pageSpacing = dimensionResource(id = R.dimen.padding_large),
        viewModel = viewModel,
        context = context,
    )
}

@Preview
@Composable
private fun AllScreenLightThemePreview() {
    DessertManiacTheme {
        AvailableDessertsScreen(
            listOfDesserts = DataSource.dessertList,
            viewModel = SweetSavorViewModel(),
        )
    }
}
@Preview
@Composable
private fun AllScreenDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        AvailableDessertsScreen(
            listOfDesserts = DataSource.dessertList,
            viewModel = SweetSavorViewModel(),
        )
    }
}