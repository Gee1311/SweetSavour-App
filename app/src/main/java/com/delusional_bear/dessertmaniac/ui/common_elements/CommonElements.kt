package com.delusional_bear.dessertmaniac.ui.common_elements

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Dessert
import com.delusional_bear.dessertmaniac.ui.theme.montserratAlternates
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarStyle

@Composable
fun HeartIcon(
    modifier: Modifier = Modifier,
    tint: Color = MaterialTheme.colorScheme.primary,
    onIconClick: () -> Unit = {}
) {
    Surface(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_medium))
            .clip(RoundedCornerShape(50))
            .clickable { onIconClick() }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.heart_icon),
            contentDescription = null,
            modifier = modifier,
            tint = tint
        )
    }
}

@Composable
fun DescriptionText(
    @StringRes text: Int,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
) {
    Text(
        text = stringResource(id = text),
        textAlign = textAlign,
        lineHeight = 30.sp,
        modifier = modifier,
        fontWeight = FontWeight.Normal,
        fontSize = 21.sp,
        fontFamily = montserratAlternates,
    )
}

@Composable
fun DessertRating(
    dessert: Dessert,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RatingBar(
            value = dessert.rating.toFloat(),
            style = RatingBarStyle.Fill(),
            onValueChange = {},
            onRatingChanged = {},
            numOfStars = 5,
            size = 16.dp,
            spaceBetween = 1.dp,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = stringResource(id = R.string.rating_1, dessert.rating),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}