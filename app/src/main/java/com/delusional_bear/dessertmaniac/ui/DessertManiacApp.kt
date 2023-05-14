package com.delusional_bear.dessertmaniac.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.model.DataSource

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DessertManiacApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            DessertManiacTopAppBar()
        },
        content = { paddingValues ->
            LazyVerticalStaggeredGrid(
                contentPadding = paddingValues,
                columns = StaggeredGridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier
                    .fillMaxSize()
                    .padding(dimensionResource(id = R.dimen.padding_small)),
                verticalItemSpacing = dimensionResource(id = R.dimen.padding_medium),
            ) {
                items(DataSource.dessertList) { dessert ->
                    DessertCard(dessert = dessert)
                }
            }
        },
    )
}