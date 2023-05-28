package com.delusional_bear.dessertmaniac.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.model.DataSource
import com.delusional_bear.dessertmaniac.model.DataSource.mainScreenRandomSloganList
import com.delusional_bear.dessertmaniac.ui.common_elements.DessertManiacCategoryCard
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    onTopMostPopularClick: () -> Unit,
    onTopMostRatedClick: () -> Unit,
    onTopWorstRatedClick: () -> Unit,
    onAllClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 30.dp,
                    vertical = dimensionResource(id = R.dimen.padding_small)
                ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_medium))
            ) {
                Text(
                    text = stringResource(id = mainScreenRandomSloganList.random()),
                    style = MaterialTheme.typography.displaySmall,
                    modifier = Modifier.padding(10.dp),
                    textAlign = TextAlign.Center,
                    lineHeight = 26.sp,
                )
            }
        }
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            verticalItemSpacing = 8.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = dimensionResource(id = R.dimen.padding_large),
                    start = dimensionResource(id = R.dimen.padding_small),
                    bottom = dimensionResource(id = R.dimen.padding_small),
                    end = dimensionResource(id = R.dimen.padding_small),
                ),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ) {
            items(DataSource.categoryAndImageList) { index ->
                when (index.first) {
                    R.string.top_most_popular -> {
                        DessertManiacCategoryCard(
                            title = index.first,
                            image = index.second,
                            onClick = onTopMostPopularClick,
                        )
                    }
                    R.string.top_most_rated -> {
                        DessertManiacCategoryCard(
                            title = index.first,
                            image = index.second,
                            onClick = onTopMostRatedClick,
                        )
                    }
                    R.string.top_worst_rated -> {
                        DessertManiacCategoryCard(
                            title = index.first,
                            image = index.second,
                            onClick = onTopWorstRatedClick,
                        )
                    }
                    R.string.all_desserts -> {
                        DessertManiacCategoryCard(
                            title = index.first,
                            image = index.second,
                            onClick = onAllClick,
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun StartScreenLightThemePreview() {
    DessertManiacTheme {
        StartScreen(
            onTopMostPopularClick = { /*TODO*/ },
            onTopMostRatedClick = { /*TODO*/ },
            onTopWorstRatedClick = { /*TODO*/ },
        ) {

        }
    }
}
@Preview
@Composable
private fun StartScreenDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        StartScreen(
            onTopMostPopularClick = { /*TODO*/ },
            onTopMostRatedClick = { /*TODO*/ },
            onTopWorstRatedClick = { /*TODO*/ },
        ) {

        }
    }
}