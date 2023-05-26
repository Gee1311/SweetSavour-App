package com.delusional_bear.dessertmaniac.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.model.DataSource.mainScreenRandomImagesList
import com.delusional_bear.dessertmaniac.model.DataSource.mainScreenRandomSloganList
import com.delusional_bear.dessertmaniac.ui.common_elements.DessertManiacCategoryButton

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    onTopMostPopularClick: () -> Unit,
    onTopMostRatedClick: () -> Unit,
    onTopWorstRatedClick: () -> Unit,
    onAllClick: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            modifier = Modifier.padding(30.dp)
        ) {
            Column(modifier = Modifier) {
                Text(
                    text = stringResource(id = mainScreenRandomSloganList.random()),
                    style = MaterialTheme.typography.displaySmall,
                    modifier = Modifier.padding(10.dp),
                    textAlign = TextAlign.Center,
                    lineHeight = 24.sp,
                )
                Image(
                    painter = painterResource(id = mainScreenRandomImagesList.random()),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }
        }
        Column(
            modifier = modifier,
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
                buttonTitle = R.string.top_worst_rated,
                onClick = onTopWorstRatedClick
            )
            DessertManiacCategoryButton(
                buttonTitle = R.string.all_desserts,
                onClick = onAllClick
            )
        }
    }
}