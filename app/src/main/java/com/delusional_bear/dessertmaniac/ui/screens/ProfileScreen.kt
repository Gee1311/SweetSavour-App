package com.delusional_bear.dessertmaniac.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.ui.elements.buttons.AccountButton
import com.delusional_bear.dessertmaniac.ui.elements.dialogs.LogoutDialog
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    onEditIconButtonClick: () -> Unit = {},
) {
    var isLogoutDialogOpened by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_large)),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.user_avatar),
                    contentDescription = stringResource(id = R.string.user_avatar),
                    modifier = modifier
                        .size(85.dp)
                        .clip(RoundedCornerShape(50.dp)),
                    contentScale = ContentScale.Crop,
                )
                Column(modifier = Modifier
                    .padding(start = dimensionResource(id = R.dimen.padding_large))
                ) {
                    Text(
                        text = stringResource(id = R.string.user_name),
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Medium,
                    )
                    Text(
                        text = stringResource(id = R.string.user_occupation),
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Normal,
                    )
                }
            }
            IconButton(onClick = onEditIconButtonClick) {
                Icon(
                    painter = painterResource(id = R.drawable.edit_icon),
                    contentDescription = null,
                    modifier = modifier.size(20.dp)
                )
            }
        }
        Column {
            Text(
                text = stringResource(id = R.string.my_account),
                style = MaterialTheme.typography.titleSmall,
                fontSize = 14.sp,
            )
            AccountButton(buttonText = R.string.switch_account) {  }
            AccountButton(buttonText = R.string.log_out) { isLogoutDialogOpened = true }
        }
    }
    if (isLogoutDialogOpened) LogoutDialog()
}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenLightThemePreview() {
    DessertManiacTheme {
        ProfileScreen()
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        ProfileScreen()
    }
}