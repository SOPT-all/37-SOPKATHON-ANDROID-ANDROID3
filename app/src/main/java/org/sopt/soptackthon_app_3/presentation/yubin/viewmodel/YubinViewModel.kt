package org.sopt.soptackthon_app_3.presentation.yubin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.soptackthon_app_3.data.network.ServicePool
import org.sopt.soptackthon_app_3.presentation.yubin.CompactUser

sealed class HelperFilter {
    object ALL : HelperFilter()
    object POPULARITY : HelperFilter()
    object DISTANCE : HelperFilter()
}

class YubinViewModel : ViewModel() {

    private val userInformationService = ServicePool.userinformationService

    private val _originalHelperList = MutableStateFlow<List<CompactUser>>(emptyList())

    private val _helperList = MutableStateFlow<List<CompactUser>>(emptyList())
    val helperList: StateFlow<List<CompactUser>> = _helperList.asStateFlow()


    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    private val _currentFilter = MutableStateFlow<HelperFilter>(HelperFilter.ALL)
    val currentFilter: StateFlow<HelperFilter> = _currentFilter.asStateFlow()

    init {

        fetchHelperList()
    }

    fun fetchHelperList() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                val response = userInformationService.getUserInfo()


                if (response.status in 200..299) {

                    val helperList = response.data.map { helper ->
                        CompactUser(
                            name = helper.name,
                            description = helper.about,
                            rating = helper.rate.toDouble(),
                            distance = "${helper.distance} mi",
                            isVerified = helper.verified,
                            profileImagePlaceholder = helper.imageURL
                        )
                    }

                    _originalHelperList.value = helperList
                    _helperList.value = helperList
                } else {
                    _errorMessage.value = response.message
                }
            } catch (e: Exception) {
                _errorMessage.value = e.message ?: "Unknown error occurred"
                _helperList.value = emptyList()
            } finally {
                _isLoading.value = false
            }
        }
    }


    fun updateFilter(filter: HelperFilter) {
        _currentFilter.value = filter

        val currentList = _helperList.value
        _helperList.value = when (filter) {
            HelperFilter.ALL -> _originalHelperList.value
            HelperFilter.POPULARITY -> currentList.sortedByDescending { it.rating }
            HelperFilter.DISTANCE -> currentList.sortedBy {
                it.distance.replace(Regex("[^0-9.]"), "").toDoubleOrNull() ?: Double.MAX_VALUE
            }
        }
    }


    fun searchHelpers(query: String) {
        if (query.isEmpty()) {
            _helperList.value = _originalHelperList.value
            return
        }

        val filtered = _originalHelperList.value.filter {
            it.name.contains(query, ignoreCase = true)
        }
        _helperList.value = filtered
    }
}