package org.sopt.sopt_collaboration_panelnow.presentation.pointexchange

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.sopt_collaboration_panelnow.domain.entity.Product
import org.sopt.sopt_collaboration_panelnow.domain.repository.GoodsCheckRepository
import org.sopt.sopt_collaboration_panelnow.domain.repository.UserRepository
import org.sopt.sopt_collaboration_panelnow.presentation.data.PointExchangeUiState
import javax.inject.Inject

@HiltViewModel
class PointExchangeViewModel @Inject constructor(
    private val goodsCheckRepository: GoodsCheckRepository,
    private val userRepository: UserRepository,
) : ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    private val _pointExchangeUiState = MutableStateFlow(PointExchangeUiState(currentPoint = 0, usedPoint = 0))
    val pointExchangeUiState: StateFlow<PointExchangeUiState> = _pointExchangeUiState

    fun getProducts(sort: String) {
        viewModelScope.launch {
            goodsCheckRepository.getProducts(sort)
                .onSuccess { list ->
                    _products.value = list
                }
                .onFailure {
                }
        }
    }

    fun getUserPoint() {
        viewModelScope.launch {
            delay(200)
            userRepository.getUser(6)
                .onSuccess { user ->
                    _pointExchangeUiState.update {
                        it.copy(
                            currentPoint = user.currentPoint,
                            usedPoint = user.usedPoint
                        )
                    }
                }
                .onFailure {
                }

        }
    }
}
