package org.sopt.soptackthon_app_3.presentation.jimin

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class ProgressUiState(
    val locateText: String = "1234 Maple Street Springfield,\n" +
            "IL 62704 USA",
    val dateText: String = "2025 / 11 / 22",
    val startTime: String = "17:00 - 20:00",
    val confirmText: String = "17:00 - 19:00",
    val serviceFee: Double = 30.0,
    val bookingFee: Double = 10.0,
    val cashText: Double = 40.0,
    val bookingInfoModel: BookingInfoModel = BookingInfoModel(
        reportContent = "Please keep an extra eye on my parents and make sure everything goes smoothly for them.",
        reportBackgroundColor = Color.White,
        reportCardHorizontalPadding = 0.dp,
        reportCardRadius = 0.dp
    ),
    val preContent: String = "",
)

data class ProgressTimeUiState(
    val isPreVisible: Boolean = false,
    val isPostVisible: Boolean = false,
)
