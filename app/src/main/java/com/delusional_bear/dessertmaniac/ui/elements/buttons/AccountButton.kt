package com.delusional_bear.dessertmaniac.ui.elements.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@Composable
fun AccountButton(
    buttonText: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        contentPadding = PaddingValues(0.dp),
    ) {
        Text(
            text = stringResource(id = buttonText),
            style = MaterialTheme.typography.titleSmall,
        )
    }
}

@Preview
@Composable
private fun AccountButtonLightThemePreview() {
    DessertManiacTheme {
        AccountButton(buttonText = R.string.switch_account)
    }
}

@Preview
@Composable
private fun AccountButtonDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        AccountButton(buttonText = R.string.log_out)
    }
}