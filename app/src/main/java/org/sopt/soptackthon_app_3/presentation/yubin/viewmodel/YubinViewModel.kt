//package org.sopt.soptackthon_app_3.presentation.yubin.viewmodel
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//
//
//
//sealed class HelperListUiState {
//    data object Loading : HelperListUiState()
//    data class Success(val helpers: List<HelperDto>) : HelperListUiState()
//    data class Error(val message: String) : HelperListUiState()
//}
//
//class YubinViewModel :ViewModel() {
//
//    private val _uiState = MutableStateFlow<HelperListUiState>(HelperListUiState.Loading)
//    val uiState: StateFlow<HelperListUiState> = _uiState
//
//    init {
//        fetchHelpers()
//    }
//
//    private fun fetchHelpers() {
//        viewModelScope.launch {
//            _uiState.value = HelperListUiState.Loading
//            try {
//                // Retrofit 통신 수행
//                val response = RetrofitClient.helperService.getBestHelpers()
//
//                // HTTP status가 200이지만, 서버 응답 구조에 따라 성공/실패 로직 분기
//                if (response.status == 200) {
//                    _uiState.value = HelperListUiState.Success(response.data)
//                } else {
//                    // 서버에서 커스텀 오류 메시지를 보낸 경우 (예: 401, 500)
//                    _uiState.value = HelperListUiState.Error(response.message)
//                }
//
//            } catch (e: Exception) {
//                // 네트워크 연결 오류, JSON 파싱 오류 등 예외 처리
//                _uiState.value = HelperListUiState.Error("네트워크 오류: ${e.localizedMessage ?: "연결 실패"}")
//            }
//        }
//    }
//}
