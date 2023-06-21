package com.delusional_bear.dessertmaniac.ui.elements.buttons

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.model.DataSource
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@Composable
fun LocationOptionButton(
    @DrawableRes icon: Int,
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.button_radius_medium)),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(0.dp),
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = icon),
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
private fun LocationOptionButtonLightThemePreview() {
    DessertManiacTheme() {
        LocationOptionButton(
            icon = DataSource.locationButtonContentList[1].first,
            title = DataSource.locationButtonContentList[1].second,
        ) {}
    }
}

@Preview
@Composable
private fun LocationOptionButtonDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        LocationOptionButton(
            icon = DataSource.locationButtonContentList[1].first,
            title = DataSource.locationButtonContentList[1].second,
        ) {}
    }
}