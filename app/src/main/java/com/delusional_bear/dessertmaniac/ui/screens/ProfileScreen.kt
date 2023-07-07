package com.delusional_bear.dessertmaniac.ui.screens

import androidx.activity.compose.BackHandler
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.ui.elements.dialogs.SignOutDialog
import com.delusional_bear.dessertmaniac.ui.sweetsavor.SweetUiState
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@Composable
fun ProfileScreen(
    uiState: SweetUiState,
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit = {},
    onDialogClick: () -> Unit = {},
    onBalanceButtonClick: () -> Unit = {},
    onPromotionButtonClick: () -> Unit = {},
    onSettingsButtonClick: () -> Unit = {},
    onOrderButtonClick: () -> Unit = {},
    onEditProfileButtonClick: () -> Unit = {},
) {
    var isExpanded by remember { mutableStateOf(false) }
    val animateImageSize by animateDpAsState(
        targetValue = if (isExpanded) 210.dp else 110.dp
    )
    BackHandler { onBackPressed.invoke() }
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_large))
                .animateContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AsyncImage(
                model = "https://images.unsplash.com/photo-1535241749838-299277b6305f?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=446&q=80",
                modifier = modifier
                    .size(animateImageSize)
                    .clip(RoundedCornerShape(100))
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onDoubleTap = { isExpanded = !isExpanded }
                        )
                    },
                contentDescription = stringResource(id = R.string.user_avatar),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.height(6.dp))
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(2.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = stringResource(id = R.string.user_name),
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = stringResource(id = R.string.user_occupation),
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Normal,
                )
                Spacer(modifier = Modifier.height(6.dp))
                Button(onClick = { onEditProfileButtonClick.invoke() }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                    ) {
                        Text(
                            text = stringResource(R.string.edit_profile),
                            style = MaterialTheme.typography.displaySmall,
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_forward_icon),
                            contentDescription = null,
                        )
                    }
                }
            }
        }
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.primary
        ) {
            Text(
                text = stringResource(R.string.content).uppercase(),
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(start = 24.dp, top = 16.dp, bottom = 8.dp),
                letterSpacing = 1.sp,
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))
        ) {
            UserOptionButton(
                icon = R.drawable.payments_icon,
                optionType = R.string.balance,
            ) {
                onBalanceButtonClick.invoke()
            }
            UserOptionButton(
                icon = R.drawable.sell_icon,
                optionType = R.string.promotions,
            ) {
                onPromotionButtonClick.invoke()
            }
            UserOptionButton(
                icon = R.drawable.list_icon,
                optionType = R.string.order,
                modifier = modifier.size(24.dp)
            ) {
                onOrderButtonClick.invoke()
            }
            UserOptionButton(
                icon = R.drawable.settings_icon,
                optionType = R.string.settings,
            ) {
                onSettingsButtonClick.invoke()
            }
            Divider()
            UserOptionButton(
                icon = R.drawable.logout_icon,
                optionType = R.string.sign_out,
                color = MaterialTheme.colorScheme.error,
            ) {
                onDialogClick.invoke()
            }
        }
    }
    if (uiState.isSignOutDialogOpened) SignOutDialog(uiState = uiState) { onDialogClick.invoke() }
}

@Composable
private fun UserInformation(
    @StringRes information: Int,
    modifier: Modifier = Modifier,
) {
    Text(
        text = stringResource(id = information),
        style = MaterialTheme.typography.displaySmall,
        modifier = modifier,
    )
}

@Composable
private fun UserOptionButton(
    @DrawableRes icon: Int,
    @StringRes optionType: Int,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    onOptionClick: () -> Unit,
) {
    TextButton(onClick = { onOptionClick.invoke() }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = color,
                modifier = modifier
            )
            Text(
                text = stringResource(id = optionType),
                style = MaterialTheme.typography.titleSmall,
                color = color,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenLightThemePreview() {
    DessertManiacTheme {
        ProfileScreen(
            uiState = SweetUiState(),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        ProfileScreen(
            uiState = SweetUiState(),
        )
    }
}