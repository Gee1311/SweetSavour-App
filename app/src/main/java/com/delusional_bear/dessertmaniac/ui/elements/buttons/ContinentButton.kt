package com.delusional_bear.dessertmaniac.ui.elements.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Continent

@Composable
fun ContinentButton(
    modifier: Modifier = Modifier,
    continent: Continent,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimensionResource(id = R.dimen.padding_large),
                vertical = dimensionResource(id = R.dimen.padding_small)
            ),
        onClick = onClick,
    ) {
        Text(
            text = stringResource(id = continent.continentName),
            style = MaterialTheme.typography.displaySmall,
            modifier = modifier
                .padding(vertical = dimensionResource(id = R.dimen.padding_small))
        )
    }
}