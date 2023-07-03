package com.delusional_bear.dessertmaniac.ui.elements.cards

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Dessert
import com.delusional_bear.dessertmaniac.data.model.DataSource
import com.delusional_bear.dessertmaniac.ui.common_functions.convertDoubleToCurrency
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@Composable
fun AvailableDessertCard(
    dessert: Dessert,
    context: Context,
    modifier: Modifier = Modifier,
    onLikeButtonClick: () -> Unit = {},
    onAddToCartClick: () -> Unit = {},
) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.padding_large))
        ) {
            Text(
                text = stringResource(id = dessert.dessertName),
                style = MaterialTheme.typography.displayMedium,
                lineHeight = 35.sp,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                LazyColumn(
                    modifier = Modifier.height(260.dp),
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
                ) {
                    items(dessert.ingredients.map { context.resources.getString(it) }) { ingredient ->
                        DessertIngredientCard(ingredient = ingredient)
                    }
                }
                AsyncImage(
                    model = dessert.dessertImageURL,
                    contentDescription = stringResource(id = dessert.dessertName),
                    modifier = modifier
                        .clip(RoundedCornerShape(8.dp))
                        .size(width = 220.dp, height = 260.dp),
                    contentScale = ContentScale.Crop,
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = convertDoubleToCurrency(dessert.price),
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Medium,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.description),
                style = MaterialTheme.typography.displaySmall,
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = stringResource(id = dessert.description),
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Justify,
                lineHeight = 20.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Button(
                    onClick = { onAddToCartClick.invoke() },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.weight(0.88f)
                ) {
                    Text(
                        text = stringResource(id = R.string.add_to_cart),
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_small))
                    )
                }
                OutlinedIconButton(
                    onClick = { onLikeButtonClick.invoke() },
                    modifier = Modifier.weight(0.12f)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.heart_icon),
                        tint = MaterialTheme.colorScheme.primary,
                        contentDescription = null,
                        modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_small))
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
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier.size(width = 105.dp, height = 80.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.padding_large)),
        ) {
            Text(
                text = ingredient,
                style = MaterialTheme.typography.labelMedium,
                fontSize = 12.sp,
                modifier = Modifier.align(alignment = Alignment.Center),
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview
@Composable
private fun AvailableDessertCardLightThemePreview() {
    val context = LocalContext.current
    DessertManiacTheme {
        AvailableDessertCard(
            dessert = DataSource.dessertList.random(),
            context = context,
        )
    }
}

@Preview
@Composable
private fun AvailableDessertCardDarkThemePreview() {
    val context = LocalContext.current
    DessertManiacTheme(darkTheme = true) {
        AvailableDessertCard(
            dessert = DataSource.dessertList.random(),
            context = context,
        )
    }
}