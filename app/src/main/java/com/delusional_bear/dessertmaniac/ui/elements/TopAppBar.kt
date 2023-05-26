package com.delusional_bear.dessertmaniac.ui.elements

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.delusional_bear.dessertmaniac.data.DessertManiac

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DessertManiacTopAppBar(
    currentScreenTitle: DessertManiac,
    canNavigate: Boolean,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(id = currentScreenTitle.title),
                    style = MaterialTheme.typography.titleLarge,
                )
            }
        },
        modifier = modifier,
        navigationIcon = {
            if (canNavigate) {
                IconButton(onClick = onNavigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null,
                    )
                }
            }
        }
    )
}