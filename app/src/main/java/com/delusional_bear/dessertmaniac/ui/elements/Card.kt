package com.delusional_bear.dessertmaniac.ui.elements

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Dessert

@Composable
fun DessertCard(
    dessert: Dessert,
    modifier: Modifier = Modifier,
) {
    var expanded by remember { mutableStateOf(false) }
    var isDialogCalled by remember { mutableStateOf(false) }

    val backgroundColor by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer else MaterialTheme.colorScheme.primaryContainer
    )
    val textColor by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.onTertiaryContainer else MaterialTheme.colorScheme.onSurface
    )

    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp,
            pressedElevation = 7.dp,
            focusedElevation = 20.dp,
        ),
        modifier = modifier.clickable { expanded = !expanded }
    ) {
        Column(
            modifier = modifier
                .animateContentSize(
                    spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessMediumLow,
                    )
                )
                .background(color = backgroundColor)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = stringResource(id = dessert.dessertName),
                    style = MaterialTheme.typography.labelMedium,
                    modifier = modifier
                        .width(135.dp)
                        .padding(
                            top = dimensionResource(id = R.dimen.padding_small),
                            bottom = dimensionResource(id = R.dimen.padding_small),
                            start = dimensionResource(id = R.dimen.padding_small),
                        ),
                    color = textColor,
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { isDialogCalled = true }) {
                    Icon(
                        painter = painterResource(id = R.drawable.bookmark),
                        contentDescription = null,
                    )
                }
            }
            Text(
                text = "${stringResource(id = R.string.rating)}: ${dessert.rating}/5.0",
                style = MaterialTheme.typography.labelMedium,
                modifier = modifier
                    .padding(
                        start = dimensionResource(id = R.dimen.padding_small),
                        bottom = dimensionResource(id = R.dimen.padding_small),
                    ),
                color = textColor,
            )
            if (isDialogCalled) {
                DessertManiacAlertDialog(dessert = dessert) { isDialogCalled = false }
            }
            Image(
                painter = painterResource(id = dessert.dessertImage),
                contentDescription = stringResource(id = dessert.dessertName),
                modifier = modifier.size(width = 300.dp, height = 177.dp)
            )
            if (expanded) {
                Column(
                    modifier = Modifier.padding(vertical = 10.dp)
                ) {
                    dessert.ingredients.forEach {
                        DessertManiacIngredientText(ingredient = it)
                    }
                }
            }
        }
    }
}