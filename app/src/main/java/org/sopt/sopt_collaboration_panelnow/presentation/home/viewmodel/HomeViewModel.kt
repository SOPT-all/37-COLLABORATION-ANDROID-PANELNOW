package org.sopt.sopt_collaboration_panelnow.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.sopt_collaboration_panelnow.domain.repository.UserRepository
import org.sopt.sopt_collaboration_panelnow.presentation.data.HomeUiState
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _homeUiState = MutableStateFlow(HomeUiState(currentPoint = 0))
    val homeUiState: StateFlow<HomeUiState> = _homeUiState

    fun getCurrentPoint() {
        viewModelScope.launch {
            userRepository.getUser(6)
                .onSuccess { user ->
                    _homeUiState.update {
                        it.copy(currentPoint = user.currentPoint)
                    }
                }.onFailure {
                }

        }
    }
}
