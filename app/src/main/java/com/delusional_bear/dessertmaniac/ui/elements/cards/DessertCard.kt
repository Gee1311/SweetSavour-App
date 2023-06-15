package com.delusional_bear.dessertmaniac.ui.elements.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Dessert

@Composable
fun DessertCard(
    dessert: Dessert,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .width(250.dp)
            .clip(RoundedCornerShape(30.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
    ) {
        Column {
            Image(
                painter = painterResource(id = dessert.dessertImage),
                contentDescription = stringResource(id = dessert.dessertName),
                modifier = Modifier
                    .size(200.dp)
                    .padding(dimensionResource(id = R.dimen.padding_small))
                    .clip(RoundedCornerShape(30.dp)),
                contentScale = ContentScale.FillBounds,
            )
            Text(
                text = stringResource(id = dessert.dessertName),
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .padding(vertical = dimensionResource(id = R.dimen.padding_large)),
                textAlign = TextAlign.Center,
            )
            LazyRow(
                modifier = Modifier
                    .width(350.dp)
                    .padding(dimensionResource(id = R.dimen.padding_small)),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
            ) {
                items(dessert.ingredients) { ingredient ->
                    IngredientCard(ingredient = ingredient)
                }
            }
        }
    }
}