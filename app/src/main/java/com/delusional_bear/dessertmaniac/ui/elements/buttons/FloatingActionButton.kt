package com.delusional_bear.dessertmaniac.ui.elements.buttons

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@Composable
fun SweetFloatingActionButton(
    modifier: Modifier = Modifier,
    onFABCLick: () -> Unit,
) {
    ExtendedFloatingActionButton(
        onClick = onFABCLick,
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.BottomEnd)
            .padding(end = dimensionResource(id = R.dimen.padding_large)),
    ) {
        Row(
            modifier = Modifier.padding(
                vertical = dimensionResource(id = R.dimen.padding_small),
                horizontal = dimensionResource(id = R.dimen.padding_large)
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.fab_icon),
                contentDescription = null,
                modifier = Modifier.size(38.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = stringResource(id = R.string.order),
                style = MaterialTheme.typography.titleSmall,
                fontSize = 18.sp,
            )
        }
    }
}

@Preview
@Composable
private fun FloatingActionButtonLightThemePreview() {
    DessertManiacTheme() {
        SweetFloatingActionButton {
            
        }
    }    
}

@Preview
@Composable
private fun FloatingActionButtonDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        SweetFloatingActionButton {
            
        }
    }
}