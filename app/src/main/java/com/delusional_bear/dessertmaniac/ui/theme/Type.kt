package com.delusional_bear.dessertmaniac.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.delusional_bear.dessertmaniac.R

val tiltprism = FontFamily(
    Font(R.font.tiltprism_regular, FontWeight.Normal)
)

val montserratAlternates = FontFamily(
    Font(R.font.montserrat_alternates_light, FontWeight.Light),
    Font(R.font.montserrat_alternates_regular, FontWeight.Normal),
    Font(R.font.montserrat_alternates_medium, FontWeight.Medium),
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontSize = 34.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = montserratAlternates,
    ),
    displayMedium = TextStyle(
        fontSize = 25.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = montserratAlternates,
    ),
    displaySmall = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = montserratAlternates,
    ),
    headlineMedium = TextStyle(
        fontSize = 21.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = montserratAlternates,
    ),
    titleLarge = TextStyle(
        fontSize = 27.sp,
        fontWeight = FontWeight.Light,
        fontFamily = montserratAlternates,
    ),
    titleSmall = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = montserratAlternates,
    ),
    labelMedium = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = montserratAlternates,
    ),
    bodySmall = TextStyle(
        fontSize = 13.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = montserratAlternates,
    ),
    bodyMedium = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = montserratAlternates,
    ),
)