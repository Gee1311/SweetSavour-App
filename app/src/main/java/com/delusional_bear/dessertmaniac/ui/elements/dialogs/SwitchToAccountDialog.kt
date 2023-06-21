package com.delusional_bear.dessertmaniac.ui.elements.dialogs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Account
import com.delusional_bear.dessertmaniac.data.model.AccountDataProvider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwitchToAccountDialog(
    modifier: Modifier = Modifier
) {
    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false }
        ) {
            Surface(
                modifier = modifier.wrapContentSize(),
                shape = MaterialTheme.shapes.large,
                tonalElevation = AlertDialogDefaults.TonalElevation
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = stringResource(id = R.string.choose_account_to_switch),
                        style = MaterialTheme.typography.displaySmall,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Divider()
                    Spacer(modifier = Modifier.height(8.dp))
                    UserEmailAccountList(
                        accountList = AccountDataProvider.listOfAccounts,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(vertical = dimensionResource(id = R.dimen.padding_small))
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Divider()
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(modifier = Modifier.align(Alignment.End)) {
                        TextButton(
                            onClick = {
                                openDialog.value = false
                            }
                        ) {
                            ButtonText(text = R.string.cancel)
                        }
                        TextButton(
                            onClick = { openDialog.value = false }
                        ) {
                            ButtonText(text = R.string.accept)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun UserEmailAccount(
    account: Account,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth(),
    ) {
        Image(
            painter = painterResource(id = account.avatar),
            contentDescription = account.fullName,
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .size(50.dp),
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_large)))
        Text(
            text = stringResource(id = account.email),
            modifier = Modifier,
            style = MaterialTheme.typography.titleSmall,
        )
    }
}

@Composable
fun UserEmailAccountList(
    accountList: List<Account>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(accountList) { account: Account ->
            UserEmailAccount(account = account)
        }
    }
}