package com.delusional_bear.dessertmaniac.ui.elements.other

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.delusional_bear.dessertmaniac.R

@Composable
fun UserAvatar(
    avatarURL: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    AsyncImage(
        model = avatarURL,
        contentDescription = stringResource(id = R.string.user_avatar),
        modifier = modifier
            .size(48.dp)
            .clip(RoundedCornerShape(100))
            .clickable { onClick() },
        contentScale = ContentScale.Crop,
    )
}