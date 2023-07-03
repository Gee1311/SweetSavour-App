package com.delusional_bear.dessertmaniac.ui.elements.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Country
import com.delusional_bear.dessertmaniac.data.model.DataSource
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@Composable
fun CountryCard(
    country: Country,
    modifier: Modifier = Modifier,
) {
    Card(elevation = CardDefaults.cardElevation(defaultElevation = 7.dp)) {
        Column(modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_small))) {
            AsyncImage(
                model = country.countryImage,
                contentDescription = stringResource(id = country.countryName),
                modifier = Modifier.size(220.dp),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = stringResource(id = country.countryName),
                style = MaterialTheme.typography.displaySmall,
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Preview
@Composable
private fun CountryCardLightThemePreview() {
    DessertManiacTheme {
        CountryCard(country = DataSource.countryList.random())
    }
}

@Preview
@Composable
private fun CountryCardDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        CountryCard(country = DataSource.countryList.random())
    }
}
