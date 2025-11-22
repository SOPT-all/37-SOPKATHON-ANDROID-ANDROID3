package org.sopt.soptackthon_app_3.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookingRequest(
    @SerialName("helperId")
    val helperId: Long,
    @SerialName("serviceOfferId")
    val serviceOfferId: Long,
    @SerialName("specialRequests")
    val specialRequests: String,
    @SerialName("startTime")
    val startTime: String, // "HH:mm" format
    @SerialName("endTime")
    val endTime: String, // "HH:mm" format
    @SerialName("estimatedFee")
    val estimatedFee: Double,
    @SerialName("reservationFee")
    val reservationFee: Double,
    @SerialName("totalEstimated")
    val totalEstimated: Double,
    @SerialName("visitDate")
    val visitDate: String, // "yyyy-MM-dd" format
    @SerialName("locate")
    val locate: String
)