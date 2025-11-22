package org.sopt.soptackthon_app_3.presentation.jimin

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class BookingInfoModel(
    val reportContent: String,
    val reportBackgroundColor: Color,
    val reportCardHorizontalPadding: Dp = 23.dp,
    val reportCardRadius: Dp = 8.dp,
)
