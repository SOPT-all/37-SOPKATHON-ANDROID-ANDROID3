package org.sopt.soptackthon_app_3.presentation.juwan.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.soptackthon_app_3.data.network.ServicePool

class JuwanViewModel : ViewModel() {

    private val bookingService = ServicePool.bookingService

    private val _uiState = MutableStateFlow(JuwanUiState())
    val uiState: StateFlow<JuwanUiState> = _uiState.asStateFlow()

    fun onEvent(event: JuwanUiEvent) {
        when (event) {
            is JuwanUiEvent.UpdateServiceOfferId -> {
                val service = ServiceData.getServiceById(event.id)
                _uiState.update {
                    it.copy(
                        serviceOfferId = event.id,
                        estimatedFee = service?.hourlyRate ?: 0.0
                    )
                }
                calculateTotal()
            }
            is JuwanUiEvent.UpdateSpecialRequests -> {
                _uiState.update { it.copy(specialRequests = event.text) }
            }
            is JuwanUiEvent.UpdateStartTime -> {
                _uiState.update { it.copy(startTime = event.time) }
            }
            is JuwanUiEvent.UpdateEndTime -> {
                _uiState.update { it.copy(endTime = event.time) }
            }
            is JuwanUiEvent.UpdateVisitDate -> {
                _uiState.update { it.copy(visitDate = event.date) }
            }
            is JuwanUiEvent.UpdateLocate -> {
                _uiState.update { it.copy(locate = event.location) }
            }
            JuwanUiEvent.ConfirmBooking -> {
                confirmBooking()
            }
        }
    }

    private fun calculateTotal() {
        val state = _uiState.value
        // Service Estimate = Hourly Rate * 2 hours (고정)
        val serviceEstimate = state.estimatedFee * state.fixedDuration
        // Total = Service Estimate + Booking Fee
        val total = serviceEstimate + state.reservationFee
        _uiState.update { it.copy(totalEstimated = total) }
    }

    private fun confirmBooking() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }

            try {
                val request = _uiState.value.toBookingRequest()
                val response = bookingService.createBooking(request)

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        isSuccess = true,
                        error = null
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        isSuccess = false,
                        error = e.message ?: "Booking failed"
                    )
                }
            }
        }
    }
}