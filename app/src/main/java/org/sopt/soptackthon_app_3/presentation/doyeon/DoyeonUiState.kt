package org.sopt.soptackthon_app_3.presentation.doyeon

import org.sopt.soptackthon_app_3.presentation.doyeon.model.HelperAvailabilityData

data class DoyeonUiState(
    val imgUrl: String = "",
    val name: String = "",
    val rate: String = "",
    val distance: String = "",
    val serviceList: List<String> = emptyList(),
    val bio: String = "",
    val experience: String = "",
    val availabilityList: List<HelperAvailabilityData> = emptyList(),
    val languageList: List<String> = emptyList(),
    val hourRates: String = "",
)