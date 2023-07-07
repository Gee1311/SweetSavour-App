package com.delusional_bear.dessertmaniac.ui.elements.cards

import android.content.Context
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Dessert
import com.delusional_bear.dessertmaniac.data.model.DataSource
import com.delusional_bear.dessertmaniac.ui.common_functions.convertDoubleToCurrency
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

enum class DessertIngredients(
    val width: Dp,
    val height: Dp,
    val borderRadius: Dp,
) {
    Normal(width = 360.dp, height = 320.dp, 4.dp),
    Shrink(width = 220.dp, height = 260.dp, 16.dp),
}

@Composable
fun AvailableDessertCard(
    dessert: Dessert,
    context: Context,
    modifier: Modifier = Modifier,
    onLikeButtonClick: () -> Unit = {},
    onAddToCartClick: () -> Unit = {},
) {
    var dessertIngredientsState by remember { mutableStateOf(DessertIngredients.Normal) }
    val transition = updateTransition(targetState = dessertIngredientsState, label = "")
    val animateWidthSize by transition.animateDp(label = "") { it.width }
    val animateHeightSize by transition.animateDp(label = "") { it.height }
    val animateBorderRadius by transition.animateDp(label = "") { it.borderRadius }
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
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize()
            ) {
                if (dessertIngredientsState == DessertIngredients.Shrink) {
                    LazyColumn(
                        modifier = Modifier.height(260.dp),
                        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
                    ) {
                        items(dessert.ingredients.map { context.resources.getString(it) }) { ingredient ->
                            DessertIngredientCard(ingredient = ingredient)
                        }
                    }
                }
                AsyncImage(
                    model = dessert.dessertImageURL,
                    contentDescription = stringResource(id = dessert.dessertName),
                    modifier = modifier
                        .clip(RoundedCornerShape(animateBorderRadius))
                        .size(width = animateWidthSize, height = animateHeightSize)
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onLongPress = {
                                    dessertIngredientsState =
                                        if (dessertIngredientsState == DessertIngredients.Normal)
                                            DessertIngredients.Shrink
                                        else
                                            DessertIngredients.Normal
                                }
                            )
                        },
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
                lineHeight = 20.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 3
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