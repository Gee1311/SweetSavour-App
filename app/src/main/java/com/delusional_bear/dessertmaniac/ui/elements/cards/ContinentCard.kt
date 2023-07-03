package com.delusional_bear.dessertmaniac.ui.elements.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Continent
import com.delusional_bear.dessertmaniac.data.model.DataSource
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@Composable
fun ContinentCard(
    continent: Continent,
    modifier: Modifier = Modifier,
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = modifier,
    ) {
        Column {
            AsyncImage(
                model = continent.continentImageURL,
                contentDescription = stringResource(id = continent.continentName),
                modifier = modifier.size(240.dp),
                contentScale = ContentScale.Crop,
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .width(IntrinsicSize.Max)
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(dimensionResource(id = R.dimen.padding_small))
            ) {
                Text(
                    text = stringResource(id = continent.continentName),
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = stringResource(id = R.string.available_shops, continent.availableShops),
                    style = MaterialTheme.typography.titleSmall,
                )
            }
        }
    }
}

@Preview
@Composable
fun ContinentCardLightThemePreview() {
    DessertManiacTheme {
        ContinentCard(continent = DataSource.continentsList.random())
    }
}


@Preview
@Composable
fun ContinentCardDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        ContinentCard(continent = DataSource.continentsList.random())
    }
}