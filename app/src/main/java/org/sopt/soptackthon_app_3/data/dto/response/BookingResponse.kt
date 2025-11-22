package org.sopt.soptackthon_app_3.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookingResponse(
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String
)