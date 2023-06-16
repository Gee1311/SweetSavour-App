package com.delusional_bear.dessertmaniac.ui.elements.other

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.ui.elements.buttons.SweetFloatingActionButton
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@Composable
fun SweetBottomAppBar(
    modifier: Modifier = Modifier,
    onHomeClicked: () -> Unit = {},
    onCartClicked: () -> Unit = {},
    onFavoritesClicked: () -> Unit = {},
    onProfileClicked: () -> Unit = {},
    onOrderClicked: () -> Unit = {},
) {
    BottomAppBar(
        content = {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(
                        start = 4.dp,
                        end = dimensionResource(id = R.dimen.padding_large),
                        top = dimensionResource(id = R.dimen.padding_medium),
                        bottom = dimensionResource(id = R.dimen.padding_medium),
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))) {
                    IconButton(onClick = onHomeClicked) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = null,
                        )
                    }
                    IconButton(onClick = onCartClicked) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = null,
                        )
                    }
                    IconButton(onClick = onFavoritesClicked) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = null,
                        )
                    }
                    IconButton(onClick = onProfileClicked) {
                        Icon(
                            imageVector = Icons.Default.AccountBox,
                            contentDescription = null,
                        )
                    }
                }
                SweetFloatingActionButton() {
                    onOrderClicked()
                }
            }
        }
    )
}

@Preview
@Composable
private fun SweetBottomAppBarLightThemePreview() {
    DessertManiacTheme {
        SweetBottomAppBar()
    }
}

@Preview
@Composable
private fun SweetBottomAppBarDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        SweetBottomAppBar()
    }
}
