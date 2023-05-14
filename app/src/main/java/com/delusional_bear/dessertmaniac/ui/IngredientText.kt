package com.delusional_bear.dessertmaniac.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R

@Composable
fun DessertManiacIngredientText(
    @StringRes ingredient: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = ingredient),
        modifier = modifier.padding(
            horizontal = dimensionResource(id = R.dimen.padding_small),
            vertical = 2.dp,
        ),
        style = MaterialTheme.typography.bodySmall,
    )
}