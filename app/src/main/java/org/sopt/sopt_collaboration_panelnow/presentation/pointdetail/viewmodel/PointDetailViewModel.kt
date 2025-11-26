package org.sopt.sopt_collaboration_panelnow.presentation.pointdetail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.sopt.sopt_collaboration_panelnow.domain.entity.GoodsCheck
import org.sopt.sopt_collaboration_panelnow.domain.repository.GoodsCheckRepository
import javax.inject.Inject

@HiltViewModel
class PointDetailViewModel @Inject constructor(
    private val goodsCheckRepository: GoodsCheckRepository,
) : ViewModel() {
    private val _goodsCheckState = MutableStateFlow(GoodsCheck.Empty)
    val goodsCheckState: StateFlow<GoodsCheck> = _goodsCheckState

    private val _purchaseSuccess = MutableStateFlow(false)
    val purchaseSuccess: StateFlow<Boolean> = _purchaseSuccess

    private val userId: Long = 1L

    fun getGoodsCheck(productId: Int) {
        viewModelScope.launch {
            goodsCheckRepository.getGoodsCheck(productId)
                .onSuccess {
                    _goodsCheckState.value = it
                }
                .onFailure {
                }
        }
    }

    fun postPurchase(productId: Int) {
        viewModelScope.launch {
            goodsCheckRepository.postPurchase(userId, productId)
                .onSuccess {
                    _purchaseSuccess.value = true
                }
                .onFailure {
                }
        }
    }

    fun resetPurchaseSuccess() {
        _purchaseSuccess.value = false
    }
}