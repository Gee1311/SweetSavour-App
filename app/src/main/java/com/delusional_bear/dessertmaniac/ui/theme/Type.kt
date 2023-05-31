package com.delusional_bear.dessertmaniac.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.delusional_bear.dessertmaniac.R

val montserratAlter = FontFamily(
    Font(R.font.montserrat_alter_medium, FontWeight.Medium),
    Font(R.font.montserrat_alter_black, FontWeight.Black),
    Font(R.font.montserrat_alter_extrabold, FontWeight.ExtraBold),
    Font(R.font.montserrat_alter_semibold, FontWeight.SemiBold),
    Font(R.font.montserrat_alter_regular, FontWeight.Normal),
    Font(R.font.montserrat_alter_bold, FontWeight.Bold),
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontSize = 34.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = montserratAlter,
    ),
    displayMedium = TextStyle(
        fontSize = 25.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = montserratAlter,
    ),
    displaySmall = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = montserratAlter,
    ),
    headlineMedium = TextStyle(
        fontSize = 21.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = montserratAlter,
    ),
    titleLarge = TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.Light,
        fontFamily = montserratAlter,
    ),
    titleSmall = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = montserratAlter,
    ),
    labelMedium = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = montserratAlter,
    ),
    bodySmall = TextStyle(
        fontSize = 13.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = montserratAlter,
    ),
    bodyMedium = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = montserratAlter,
    ),
)