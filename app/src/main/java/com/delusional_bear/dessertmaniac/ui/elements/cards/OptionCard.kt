package com.delusional_bear.dessertmaniac.ui.elements.cards

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R

@Composable
fun OptionCard(
    @DrawableRes optionImage: Int,
    @StringRes optionTitle: Int,
    optionSize: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = modifier
            .size(width = 200.dp, height = 325.dp)
            .clickable { onClick() },
    ) {
        Column {
            Image(
                painter = painterResource(id = optionImage),
                contentDescription = stringResource(id = optionTitle),
            )
            Text(
                text = stringResource(id = optionTitle),
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .padding(dimensionResource(id = R.dimen.padding_small)),
                textAlign = TextAlign.Center,
            )
            Text(
                text = stringResource(id = R.string.items, optionSize),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.titleSmall,
            )
        }
    }
}