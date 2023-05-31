package com.delusional_bear.dessertmaniac.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Country

@Composable
fun CountryCard(
    country: Country,
    modifier: Modifier = Modifier,
    onCardClick: () -> Unit,
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp,
        ),
        modifier = modifier
            .height(240.dp)
            .clickable { onCardClick() },
    ) {
        Image(
            painter = painterResource(id = country.countryImage), 
            contentDescription = stringResource(id = country.countryName),
            modifier = modifier.size(200.dp),
            contentScale = ContentScale.Crop,
        )
        Text(
            text = stringResource(id = country.countryName),
            style = MaterialTheme.typography.titleSmall,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                .padding(dimensionResource(id = R.dimen.padding_small)),
            fontWeight = FontWeight.Medium,
        )
    }
}