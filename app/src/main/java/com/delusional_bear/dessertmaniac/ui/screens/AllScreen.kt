package com.delusional_bear.dessertmaniac.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.delusional_bear.dessertmaniac.data.Dessert
import com.delusional_bear.dessertmaniac.model.DataSource
import com.delusional_bear.dessertmaniac.ui.elements.lists.DessertList
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@Composable
fun AllScreen(
    listOfDesserts: List<Dessert>,
    modifier: Modifier = Modifier,
) {
    DessertList(
        list = listOfDesserts.shuffled(),
        modifier = modifier
    )
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