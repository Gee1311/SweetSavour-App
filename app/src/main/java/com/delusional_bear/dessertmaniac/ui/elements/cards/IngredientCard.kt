package com.delusional_bear.dessertmaniac.ui.elements.cards

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.delusional_bear.dessertmaniac.R

@Composable
fun IngredientCard(
    ingredient: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .size(width = 100.dp, height = 55.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        ),
        shape = RoundedCornerShape(25.dp),
    ) {
        Text(
            text = stringResource(id = ingredient),
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
                .padding(dimensionResource(id = R.dimen.padding_large)),
            textAlign = TextAlign.Center,
            fontSize = 15.sp,
        )
    }
}