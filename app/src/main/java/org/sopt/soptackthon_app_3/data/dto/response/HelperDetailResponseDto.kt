package org.sopt.soptackthon_app_3.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HelperDetailResponseDto(
    @SerialName("helperId")
    val helperId: Long,
    @SerialName("imageURL")
    val imageUrl: String,
    @SerialName("name")
    val name: String,
    @SerialName("rate")
    val rate: Float,
    @SerialName("verified")
    val verified: Boolean,
    @SerialName("serviceOffers")
    val serviceOffers: List<ServiceOfferDto>,
    @SerialName("about")
    val about: String,
    @SerialName("experience")
    val experience: String,
    @SerialName("availabilities")
    val availabilities: List<AvailabilityDto>,
    @SerialName("languages")
    val languages: List<String>,
    @SerialName("hourlyRate")
    val hourlyRate: Float,
)

@Serializable
data class ServiceOfferDto(
    @SerialName("serviceOfferId")
    val serviceOfferId: Long,
    @SerialName("name")
    val name: String,
    @SerialName("takenTime")
    val takenTime: Int,
    @SerialName("serviceFee")
    val serviceFee: Float,
)

@Serializable
data class AvailabilityDto(
    @SerialName("availableDayOfTheWeek")
    val availableDayOfTheWeek: String,
    @SerialName("availableTime")
    val availableTime: String,
)
