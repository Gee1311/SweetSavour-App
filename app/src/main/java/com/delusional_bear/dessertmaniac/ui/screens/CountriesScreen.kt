package com.delusional_bear.dessertmaniac.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.SweetUiState
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@Composable
fun CountriesScreen(
    uiState: SweetUiState,
    modifier: Modifier = Modifier,
) {
    val messageToDisplay = stringResource(id = R.string.continent_chosen, uiState.continent)
    Text(text = messageToDisplay)
}

@Preview
@Composable
private fun CountriesScreenLightThemePreview() {
    DessertManiacTheme {
        CountriesScreen(SweetUiState(false, "Asia"))
    }
}

@Preview
@Composable
private fun CountriesScreenDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        CountriesScreen(SweetUiState(false, "Europe"))
    }
}