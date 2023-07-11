package com.delusional_bear.dessertmaniac.ui.elements.dialogs

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R

@Composable
fun ConfirmedOrderDetailsDialog(
    paymentMethod: String,
    destination: String,
    modifier: Modifier = Modifier,
    onConfirmButtonClick: () -> Unit = {},
    onDismissButtonClick: () -> Unit = {},
) {
    AlertDialog(
        onDismissRequest = { /* it's left empty because user need either to confirm or cancel an order */ },
        confirmButton = {
            Button(
                onClick = onConfirmButtonClick,
                shape = RoundedCornerShape(8.dp),
            ) {
                Text(
                    text = stringResource(id = R.string.ok),
                    style = MaterialTheme.typography.titleSmall,
                )
            }
        },
        dismissButton = {
            Button(
                onClick = onDismissButtonClick,
                shape = RoundedCornerShape(8.dp),
            ) {
                Text(
                    text = stringResource(id = R.string.cancel),
                    style = MaterialTheme.typography.titleSmall,
                )
            }
        },
        title = {
            Text(
                text = stringResource(id = R.string.confirmed_order_details_text),
                style = MaterialTheme.typography.headlineMedium,
            )
        },
        text = {
            Text(
                text = stringResource(
                    id = R.string.confirmed_order_details,
                    paymentMethod,
                    destination
                ),
                style = MaterialTheme.typography.titleSmall,
            )
        },
        icon = {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
            )
        },
        modifier = modifier,
    )
}