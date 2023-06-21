package com.delusional_bear.dessertmaniac.data

import androidx.annotation.DrawableRes

/**
 * [Account] is a data class that represents a user's account with
 * all information like name, email etc.
 */

data class Account(
    val id: Long,
    val firstName: Int,
    val lastName: Int,
    val email: Int,
    @DrawableRes val avatar: Int,
) {
    val fullName = "$firstName $lastName"
}
