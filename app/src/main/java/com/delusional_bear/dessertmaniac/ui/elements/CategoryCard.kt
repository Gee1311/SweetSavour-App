package com.delusional_bear.dessertmaniac.ui.elements

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R

@Composable
fun CategoryCard(
    @StringRes title: Int,
    @DrawableRes image: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    OutlinedCard(
        elevation = CardDefaults.outlinedCardElevation(
            defaultElevation = 10.dp,
        ),
        modifier = Modifier
            .width(200.dp)
            .clickable { onClick() }
    ) {
        Column(modifier = modifier) {
            Text(
                text = stringResource(id = title),
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .padding(dimensionResource(id = R.dimen.padding_medium)),
                textAlign = TextAlign.Center,
            )
            Image(
                painter = painterResource(id = image),
                contentDescription = stringResource(id = title),
                modifier = Modifier.height(200.dp),
                contentScale = ContentScale.Crop,
            )
        }
    }
}