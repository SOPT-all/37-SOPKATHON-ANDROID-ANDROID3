package org.sopt.soptackthon_app_3.presentation.doyeon.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.sopt.soptackthon_app_3.presentation.doyeon.DoyeonUiState

class DoyeonViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DoyeonUiState())
    val uiState = _uiState.asStateFlow()
}