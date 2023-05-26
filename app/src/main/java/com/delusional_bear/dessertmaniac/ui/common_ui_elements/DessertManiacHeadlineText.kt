package com.delusional_bear.dessertmaniac.ui.common_ui_elements

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun DessertManiacHeadlineText(
    @StringRes textToDisplay: Int,
    modifier: Modifier = Modifier,
) {
    Text(
        text = stringResource(id = textToDisplay),
        style = MaterialTheme.typography.displayMedium,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}