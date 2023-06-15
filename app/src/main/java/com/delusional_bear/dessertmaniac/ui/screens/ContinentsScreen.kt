package com.delusional_bear.dessertmaniac.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
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
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.model.DataSource
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@Composable
fun ContinentsScreen(
    continentsList: List<String>,
    modifier: Modifier = Modifier,
    onSelectedContinent: (String) -> Unit = {},
    onNextButtonClick: () -> Unit = {},
    onCancelButtonClick: () -> Unit = {},
) {
    var selectedContinent by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_small)),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = R.string.choose_continent),
            style = MaterialTheme.typography.headlineMedium,
        )
        Column {
            continentsList.forEach { continent ->
                Row(
                    modifier = Modifier.selectable(
                        selected = selectedContinent == continent,
                        onClick = {
                            selectedContinent = continent
                            onSelectedContinent(continent)
                        }
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    RadioButton(
                        selected = selectedContinent == continent,
                        onClick = {
                            selectedContinent = continent
                            onSelectedContinent(continent)
                        }
                    )
                    Text(
                        text = continent,
                        style = MaterialTheme.typography.displaySmall,
                        modifier = modifier
                            .padding(vertical = dimensionResource(id = R.dimen.padding_small))
                    )
                }
            }
        }
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
                enabled = selectedContinent.isNotEmpty()
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
    val context = LocalContext.current
    DessertManiacTheme {
        ContinentsScreen(
            continentsList = DataSource.continentsList.map { context.resources.getString(it.continentName) }
        )
    }
}

@Preview
@Composable
private fun ContinentsScreenDarkThemePreview() {
    val context = LocalContext.current
    DessertManiacTheme(darkTheme = true) {
        ContinentsScreen(
            continentsList = DataSource.continentsList.map { context.resources.getString(it.continentName) }
        )
    }
}