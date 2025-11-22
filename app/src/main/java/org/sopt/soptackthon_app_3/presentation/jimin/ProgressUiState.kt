package org.sopt.soptackthon_app_3.presentation.jimin

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class ProgressUiState(
    val locateText: String = "",
    val dateText: String = "",
    val startTime: String = "",
    val confirmText: String = "",
    val serviceFee: Int = 0,
    val bookingFee: Int = 0,
    val cashText: Int = 0,
    val bookingInfoModel: BookingInfoModel = BookingInfoModel(
        reportContent = "adfasdfasdfasd",
        reportBackgroundColor = Color.White,
        reportCardHorizontalPadding = 0.dp,
        reportCardRadius = 0.dp
    ),
    val preContent: String = "",
)

data class ProgressTimeUiState(
    val isVisible: Boolean = false
)
