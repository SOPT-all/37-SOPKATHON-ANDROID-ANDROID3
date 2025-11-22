
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.soptackthon_app_3.data.network.ServicePool
import org.sopt.soptackthon_app_3.data.service.UserInformationService
import org.sopt.soptackthon_app_3.presentation.juwan.viewmodel.JuwanUiEvent
import org.sopt.soptackthon_app_3.presentation.juwan.viewmodel.JuwanUiState
import org.sopt.soptackthon_app_3.presentation.juwan.viewmodel.ServiceData




class YubinViewModel: ViewModel() {


    //private val UserInformationService = ServicePool.UserInformationService

    private val _uiState = MutableStateFlow(JuwanUiState())
    val uiState: StateFlow<JuwanUiState> = _uiState.asStateFlow()

}

    // 헬퍼 목록 데이터 상태
    private val _helperList = MutableStateFlow<List<CompactUser>>(emptyList())
    val helperList: StateFlow<List<CompactUser>> = _helperList.asStateFlow()

    // 로딩 상태
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    // 에러 메시지 상태
    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    // 현재 선택된 필터 상태 (변경 없음)
    //private val _currentFilter = MutableStateFlow(HelperFilter.ALL)
    //val currentFilter: StateFlow<HelperFilter> = _currentFilter.asStateFlow()





