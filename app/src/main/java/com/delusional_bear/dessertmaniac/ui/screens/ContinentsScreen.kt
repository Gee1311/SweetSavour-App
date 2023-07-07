package com.delusional_bear.dessertmaniac.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Continent
import com.delusional_bear.dessertmaniac.data.model.DataSource
import com.delusional_bear.dessertmaniac.ui.common_elements.DescriptionText
import com.delusional_bear.dessertmaniac.ui.elements.cards.ContinentCard
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContinentsScreen(
    continentsList: List<Continent>,
    modifier: Modifier = Modifier,
    onSelectedContinent: (Int) -> Unit = {},
    onNextButtonClick: () -> Unit = {},
    onCancelButtonClick: () -> Unit = {},
) {
    var selectedContinent by rememberSaveable { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_small)),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        DescriptionText(text = R.string.choose_continent)
        HorizontalPager(
            pageCount = continentsList.size,
            pageContent = { index ->
                val continent = continentsList[index].continentName
                ContinentCard(
                    continent = continentsList[index],
                    modifier = Modifier.selectable(
                        selected = selectedContinent == continent,
                        onClick = {
                            selectedContinent = continent
                            onSelectedContinent(continent)
                        }
                    )
                )
            },
            modifier = Modifier.size(320.dp)
        )
        Row(modifier = Modifier.weight(1f, fill = false)) {
            OutlinedButton(
                onClick = onCancelButtonClick,
                modifier = Modifier
                    .weight(1f)
                    .padding(dimensionResource(id = R.dimen.padding_large))
            ) {
                Text(
                    text = stringResource(id = R.string.cancel),
                    style = MaterialTheme.typography.titleSmall,
                    modifier = modifier.padding(vertical = dimensionResource(id = R.dimen.padding_small))
                )
            }
            Button(
                onClick = onNextButtonClick,
                modifier = Modifier
                    .weight(1f)
                    .padding(dimensionResource(id = R.dimen.padding_large)),
                enabled = selectedContinent != 0
            ) {
                Text(
                    text = stringResource(id = R.string.next),
                    style = MaterialTheme.typography.titleSmall,
                    modifier = modifier.padding(vertical = dimensionResource(id = R.dimen.padding_small))
                )
            }
        }
    }
}

@Preview
@Composable
private fun ContinentsScreenLightThemePreview() {
    DessertManiacTheme {
        ContinentsScreen(
            continentsList = DataSource.continentsList,
        )
    }
}

@Preview
@Composable
private fun ContinentsScreenDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        ContinentsScreen(
            continentsList = DataSource.continentsList,
        )
    }
}