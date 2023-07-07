package com.delusional_bear.dessertmaniac.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.ui.common_elements.DescriptionText
import com.delusional_bear.dessertmaniac.ui.elements.cards.CountryCard
import com.delusional_bear.dessertmaniac.ui.sweetsavor.SweetUiState
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CountriesScreen(
    uiState: SweetUiState,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))) {
            DescriptionText(text = R.string.list_of_countries)
            Text(
                text = stringResource(id = uiState.continent),
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                letterSpacing = 1.sp,
                fontWeight = FontWeight.Medium,
            )
            Spacer(modifier = Modifier.height(8.dp))
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
                verticalItemSpacing = dimensionResource(id = R.dimen.padding_small)
            ) {
                uiState.countries[uiState.continent]?.let {
                    items(it) { country ->
                        CountryCard(country = country)
                    }
                }
            }
        }
    }
}


@Preview
@Composable
private fun CountriesScreenLightThemePreview() {
    DessertManiacTheme {
        CountriesScreen(SweetUiState())
    }
}

@Preview
@Composable
private fun CountriesScreenDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        CountriesScreen(SweetUiState())
    }
}