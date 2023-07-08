package com.delusional_bear.dessertmaniac.ui.common_functions

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.delusional_bear.dessertmaniac.data.Dessert
import com.delusional_bear.dessertmaniac.data.SweetSavor
import java.text.NumberFormat

/**
 * [convertDoubleToCurrency] function is used to convert the given price of a dessert into the currency value
 * Example: 8.99 ---> $8.99
 */

fun convertDoubleToCurrency(price: Number): String = NumberFormat.getCurrencyInstance().format(price).replace("$", "$ ")


/**
 * [totalPriceOfOrderedDesserts] function is used to calculate the total price of a user's order
 * @see sumOf
 */

fun totalPriceOfOrderedDesserts(dessertList: List<Dessert>): Double = dessertList.sumOf { it.price }

/**
 * [cancelAndNavigateBack] function is used to pop up all of the screen in back stack and navigate to the start destination
 * @see NavHostController
 */

fun cancelAndNavigateBack(navController: NavHostController) {
    navController.popBackStack(SweetSavor.Home.name, false)
}

fun displayToastMessage(context: Context, message: Int, toastLength: Int) {
    Toast.makeText(context, context.resources.getText(message), toastLength).show()
}