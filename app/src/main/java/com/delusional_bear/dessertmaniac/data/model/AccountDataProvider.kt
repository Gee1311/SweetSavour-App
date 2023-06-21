package com.delusional_bear.dessertmaniac.data.model

import com.delusional_bear.dessertmaniac.R
import com.delusional_bear.dessertmaniac.data.Account

object AccountDataProvider {
    val defaultAccount = Account(-1, -1, -1 ,-1, -1)

    val listOfAccounts = listOf(
        Account(
            1L,
            R.string.user_first_name_1,
            R.string.user_last_name_1,
            R.string.email_1,
            R.drawable.avatar_1,
        ),
        Account(
            2L,
            R.string.user_first_name_1,
            R.string.user_last_name_1,
            R.string.email_2,
            R.drawable.avatar_3,
        ),
        Account(
            3L,
            R.string.user_first_name_1,
            R.string.user_last_name_1,
            R.string.email_3,
            R.drawable.avatar_2,
        )
    )

    fun getAccount(accountId: Long) : Account = listOfAccounts.firstOrNull { it.id == accountId } ?: defaultAccount
}