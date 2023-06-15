package com.delusional_bear.dessertmaniac.ui.elements.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.MostOrderedDessert
import com.delusional_bear.dessertmaniac.model.DataSource
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@Composable
fun MostOrderedCard(
    dessert: MostOrderedDessert,
    modifier: Modifier = Modifier
) {
    Box {
        OutlinedCard(
            elevation = CardDefaults.outlinedCardElevation(4.dp),
        ) {
            Column {
                Image(
                    painter = painterResource(id = dessert.dessertImage),
                    contentDescription = stringResource(id = dessert.dessertName),
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.padding_small))
                        .clip(RoundedCornerShape(10.dp)),
                )
                Text(
                    text = stringResource(id = R.string.orders, dessert.orders),
                    style = MaterialTheme.typography.labelMedium,
                    modifier = modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                        .padding(vertical = dimensionResource(id = R.dimen.padding_small)),
                )
            }
        }
        if (dessert.rating == 5.0)
            Box(modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(color = MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    text = stringResource(id = R.string.rating_with_value, dessert.rating),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = modifier.fillMaxSize().wrapContentSize(Alignment.Center)
                )
            }
    }
}

@Preview
@Composable
private fun MostOrderedCardLightThemePreview() {
    DessertManiacTheme {
        MostOrderedCard(dessert = DataSource.mostOrderedDessertsList.first())
    }
}

@Preview
@Composable
private fun MostOrderedCardDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        MostOrderedCard(dessert = DataSource.mostOrderedDessertsList[2])
    }
}