package com.delusional_bear.dessertmaniac.ui.elements.buttons

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@Composable
fun SweetFloatingActionButton(
    modifier: Modifier = Modifier,
    onFABCLick: () -> Unit,
) {
    FloatingActionButton(
        onClick = onFABCLick,
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.padding(
                vertical = dimensionResource(id = R.dimen.padding_small),
                horizontal = dimensionResource(id = R.dimen.padding_large)
            ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.fab_icon),
                contentDescription = null,
                modifier = Modifier.size(38.dp),
            )
        }
    }
}

@Preview
@Composable
private fun FloatingActionButtonLightThemePreview() {
    DessertManiacTheme {
        SweetFloatingActionButton {}
    }
}

@Preview
@Composable
private fun FloatingActionButtonDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        SweetFloatingActionButton {}
    }
}