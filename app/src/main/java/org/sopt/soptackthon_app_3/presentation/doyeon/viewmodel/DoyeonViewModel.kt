package org.sopt.soptackthon_app_3.presentation.doyeon.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.soptackthon_app_3.data.network.ServicePool
import org.sopt.soptackthon_app_3.presentation.doyeon.DoyeonUiState
import org.sopt.soptackthon_app_3.presentation.doyeon.model.HelperAvailabilityData

class DoyeonViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DoyeonUiState())
    val uiState = _uiState.asStateFlow()

    fun fetchHelperData(
        helperId: Int,
    ) {
        viewModelScope.launch {
            try {
                val result = ServicePool.helperDetailService.getHelperInfo(helperId)
                val data = result.data
                val serviceList = data.serviceOffers.map { dto ->
                    dto.name
                }
                val availabilityList = data.availabilities.map { dto ->
                    HelperAvailabilityData(
                        weekday = dto.availableDayOfTheWeek,
                        time = dto.availableTime
                    )
                }
                _uiState.update { currentState ->
                    currentState.copy(
                        imgUrl = data.imageUrl,
                        name = data.name,
                        rate = data.rate,
                        distance = "0.2 mi",
                        serviceList = serviceList,
                        bio = data.about,
                        experience = data.experience,
                        availabilityList = availabilityList,
                        languageList = data.languages,
                        hourRates = data.hourlyRate
                    )
                }
            } catch (e: Exception) {
            }
        }
    }
}