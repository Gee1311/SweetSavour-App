package com.delusional_bear.dessertmaniac.ui.elements.other

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.SweetSavor
import com.delusional_bear.dessertmaniac.ui.theme.tiltprism

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SweetTopAppBar(
    currentScreenTitle: SweetSavor,
    canNavigate: Boolean,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(id = R.dimen.padding_small)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = if (!canNavigate) Arrangement.SpaceBetween else Arrangement.SpaceAround,
            ) {
                Text(
                    text = stringResource(id = currentScreenTitle.title),
                    style = MaterialTheme.typography.titleLarge,
                    fontFamily = tiltprism
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