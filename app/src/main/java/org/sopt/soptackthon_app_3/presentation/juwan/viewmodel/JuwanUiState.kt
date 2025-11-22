package org.sopt.soptackthon_app_3.presentation.juwan.viewmodel

import org.sopt.soptackthon_app_3.data.dto.request.BookingRequest

data class JuwanUiState(
    val helperId: Long = 8L,
    val serviceOfferId: Long = 0L,
    val specialRequests: String = "Enter any special requests or notes for the helper.",
    val startTime: String = "17:00",
    val endTime: String = "20:00",
    val estimatedFee: Double = 0.0,
    val reservationFee: Double = 10.0,
    val fixedDuration: Double = 2.0,
    val totalEstimated: Double = 0.0,
    val visitDate: String = "2025/11/22",
    val locate: String = "1234 Maple Street Springfield IL 62704 USA",
    val isLoading: Boolean = false,
    val error: String? = null,
    val isSuccess: Boolean = false,
) {
    fun toBookingRequest(): BookingRequest {
        return BookingRequest(
            helperId = helperId,
            serviceOfferId = serviceOfferId,
            specialRequests = specialRequests,
            startTime = startTime,
            endTime = endTime,
            estimatedFee = estimatedFee,
            reservationFee = reservationFee,
            totalEstimated = totalEstimated,
            visitDate = visitDate,
            locate = locate
        )
    }

    val serviceEstimate: Double
        get() = estimatedFee * fixedDuration
}

sealed class JuwanUiEvent {
    data class UpdateServiceOfferId(val id: Long) : JuwanUiEvent()
    data class UpdateSpecialRequests(val text: String) : JuwanUiEvent()
    data class UpdateStartTime(val time: String) : JuwanUiEvent()
    data class UpdateEndTime(val time: String) : JuwanUiEvent()
    data class UpdateVisitDate(val date: String) : JuwanUiEvent()
    data class UpdateLocate(val location: String) : JuwanUiEvent()
    object ConfirmBooking : JuwanUiEvent()
}