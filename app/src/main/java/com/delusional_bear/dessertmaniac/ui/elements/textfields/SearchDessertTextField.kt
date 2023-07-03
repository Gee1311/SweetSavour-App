package com.delusional_bear.dessertmaniac.ui.elements.textfields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.ui.sweetsavor.SweetSavorViewModel

@Composable
fun SearchDessertTextField(
    sweetSavorViewModel: SweetSavorViewModel,
    keyboardActions: KeyboardActions,
    isDessertAvailable: Boolean,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = sweetSavorViewModel.dessertName,
        onValueChange = { sweetSavorViewModel.inputDessertName(it) },
        placeholder = {
            if (isDessertAvailable) {
                Text(
                    text = stringResource(id = R.string.available_dessert),
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 18.sp,
                )
            } else {
                Text(
                    text = stringResource(id = R.string.search),
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 18.sp,
                )
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = dimensionResource(id = R.dimen.padding_large)),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
            )
        },
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        singleLine = true,
        textStyle = MaterialTheme.typography.titleSmall,
    )
}