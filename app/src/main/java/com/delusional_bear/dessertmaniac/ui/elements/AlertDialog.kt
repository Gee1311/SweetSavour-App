package com.delusional_bear.dessertmaniac.ui.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Dessert

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DessertManiacAlertDialog(
    modifier: Modifier = Modifier,
    dessert: Dessert,
    onDialogClick: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDialogClick,
        content = {
            Surface(
                modifier = modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                shape = MaterialTheme.shapes.large,
                tonalElevation = AlertDialogDefaults.TonalElevation
            ) {
                Column(modifier = modifier.padding(16.dp)) {
                    Text(
                        text = stringResource(id = R.string.dessert_added, stringResource(id = dessert.dessertName)),
                        style = MaterialTheme.typography.bodyMedium,
                        lineHeight = 22.sp,
                    )
                    Spacer(modifier = modifier.height(24.dp))
                    Row(
                        modifier = modifier.align(Alignment.End),
                    ) {
                        TextButton(
                            onClick = onDialogClick,
                            modifier = modifier,
                        ) {
                            Text(
                                text = stringResource(id = R.string.cancel),
                                style = MaterialTheme.typography.labelMedium,
                            )
                        }
                        TextButton(
                            onClick = onDialogClick,
                            modifier = modifier,
                        ) {
                            Text(
                                text = stringResource(id = R.string.confirm),
                                style = MaterialTheme.typography.labelMedium,
                            )
                        }
                    }
                }
            }
        },
    )
}