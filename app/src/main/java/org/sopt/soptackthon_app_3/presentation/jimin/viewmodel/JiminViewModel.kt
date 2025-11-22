package org.sopt.soptackthon_app_3.presentation.jimin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.soptackthon_app_3.presentation.jimin.ProgressTimeUiState
import org.sopt.soptackthon_app_3.presentation.jimin.ProgressUiState

class JiminViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ProgressUiState())
    val uiState: StateFlow<ProgressUiState> = _uiState.asStateFlow()

    private val _timeUiState = MutableStateFlow(ProgressTimeUiState())
    val timeUiState: StateFlow<ProgressTimeUiState> = _timeUiState.asStateFlow()


    fun updateProgressInfo(tab: String) {
        _uiState.update { it.copy() }
    }


    init {
        viewModelScope.launch {
            delay(5000L)
            _timeUiState.update { it.copy(isVisible = true)
            }
        }
    }
}