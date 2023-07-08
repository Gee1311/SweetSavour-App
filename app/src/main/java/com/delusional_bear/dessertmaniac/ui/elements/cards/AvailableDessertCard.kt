package com.delusional_bear.dessertmaniac.ui.elements.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Dessert
import com.delusional_bear.dessertmaniac.ui.common_functions.convertDoubleToCurrency
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarStyle

@Composable
fun AvailableDessertCard(
    dessert: Dessert,
    modifier: Modifier = Modifier,
    onFavoriteClick: () -> Unit = {},
    onCartClick: () -> Unit = {},
) {
    val context = LocalContext.current
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp,
            pressedElevation = 20.dp,
        ),
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
    ) {
        Column(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))) {
            Row(
                modifier = Modifier.fillMaxWidth(1f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = stringResource(id = dessert.dessertName),
                    style = MaterialTheme.typography.displaySmall,
                    lineHeight = 26.sp,
                    modifier = Modifier.requiredWidthIn(max = 265.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.heart_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { onFavoriteClick() },
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                RatingBar(
                    value = dessert.rating.toFloat(),
                    style = RatingBarStyle.Default,
                    onValueChange = {},
                    onRatingChanged = {},
                    numOfStars = 1,
                    size = 20.dp
                )
                Text(
                    text = dessert.rating.toString(),
                    style = MaterialTheme.typography.labelMedium,
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(1f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                AsyncImage(
                    model = dessert.dessertImageURL,
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 210.dp, height = 230.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop,
                )
                LazyColumn(
                    modifier = Modifier.height(230.dp),
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
                ) {
                    val ingredients = dessert.ingredients.map { ingredientId ->
                        context.resources.getText(ingredientId)
                    }
                    items(ingredients) { ingredient ->
                        DessertIngredientCard(ingredient = ingredient.toString())
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(1f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = convertDoubleToCurrency(dessert.price),
                    style = MaterialTheme.typography.displayMedium
                )
                Button(
                    onClick = onCartClick,
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.add_to_cart),
                        style = MaterialTheme.typography.labelMedium,
                    )
                }
            }
        }
    }
}

@Composable
private fun DessertIngredientCard(
    ingredient: String,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.size(width = 110.dp, height = 90.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = ingredient,
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Center,
            )
        }
    }
}