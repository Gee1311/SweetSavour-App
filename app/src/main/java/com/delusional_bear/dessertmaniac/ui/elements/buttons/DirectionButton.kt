package com.delusional_bear.dessertmaniac.ui.elements.buttons

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.model.DataSource.locationButtonContentList
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@Composable
fun DirectionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val (icon, title) = locationButtonContentList.first()
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.button_radius_medium)),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = modifier.size(16.dp),
            )
            Spacer(modifier = modifier.width(8.dp))
            Text(
                text = stringResource(id = title),
                style = MaterialTheme.typography.labelMedium,
            )
        }
    }
}

@Preview
@Composable
fun DirectionButtonLightThemePreview() {
    DessertManiacTheme() {
        DirectionButton(onClick = { /*TODO*/ })
    }
}

@Preview
@Composable
fun DirectionButtonDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        DirectionButton(onClick = { /*TODO*/ })
    }
}