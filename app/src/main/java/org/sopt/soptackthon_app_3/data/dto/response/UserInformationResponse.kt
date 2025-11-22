package org.sopt.soptackthon_app_3.data.dto.response

import android.service.autofill.UserData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserInformationResponse(
    @SerialName("helperId")
    val helperId: Long,
    @SerialName("imageURL")
    val imageURL: String,
    @SerialName("name")
    val name: String,
    @SerialName("about")
    val about: String,
    @SerialName("rate")
    val rate: Float,
    @SerialName("distance")
    val distance: String,
    @SerialName("verified")
    val verified: Boolean
)

