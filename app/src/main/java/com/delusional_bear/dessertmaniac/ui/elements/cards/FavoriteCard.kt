package com.delusional_bear.dessertmaniac.ui.elements.cards

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Dessert
import com.delusional_bear.dessertmaniac.data.model.DataSource
import com.delusional_bear.dessertmaniac.ui.common_elements.DessertRating
import com.delusional_bear.dessertmaniac.ui.common_functions.convertDoubleToCurrency
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@Composable
fun FavoriteCard(
    dessert: Dessert,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier) {
        Column(modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_small))) {
            Box(contentAlignment = Alignment.TopEnd) {
                AsyncImage(
                    model = dessert.dessertImageURL,
                    contentDescription = stringResource(id = dessert.dessertName),
                    modifier = Modifier.size(200.dp),
                    contentScale = ContentScale.Crop,
                )
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.padding_small))
                        .clip(RoundedCornerShape(50.dp))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.heart_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(4.dp)
                            .size(24.dp),
                        tint = Color.Red,
                    )
                }
            }
            Column(
                modifier = Modifier
                    .requiredWidthIn(max = 185.dp)
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(
                        start = dimensionResource(id = R.dimen.padding_small),
                        top = dimensionResource(id = R.dimen.padding_small),
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = stringResource(id = dessert.dessertName),
                    style = MaterialTheme.typography.titleSmall,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(4.dp))
                DessertRating(dessert = dessert)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = convertDoubleToCurrency(dessert.price),
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Medium,
                )
            }
        }
    }
}

@Preview
@Composable
fun FavoriteCardLightThemePreview() {
    DessertManiacTheme {
        FavoriteCard(dessert = DataSource.dessertList.random())
    }
}

@Preview
@Composable
fun FavoriteCardDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        FavoriteCard(dessert = DataSource.dessertList.random())
    }
}