package com.delusional_bear.dessertmaniac.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.ui.common_ui_elements.DessertManiacCategoryButton

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    onTopMostPopularClick: () -> Unit,
    onTopMostRatedClick: () -> Unit,
    onTopWorstRatedClick: () -> Unit,
    onAllClick: () -> Unit,
) {
    Row(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ) {
            DessertManiacCategoryButton(
                buttonTitle = R.string.top_most_popular,
                onClick = onTopMostPopularClick
            )
            DessertManiacCategoryButton(
                buttonTitle = R.string.top_most_rated,
                onClick = onTopMostRatedClick
            )
            DessertManiacCategoryButton(
                buttonTitle = R.string.top_most_popular,
                onClick = onTopWorstRatedClick
            )
            DessertManiacCategoryButton(
                buttonTitle = R.string.top_most_rated,
                onClick = onAllClick
            )
        }
    }
}