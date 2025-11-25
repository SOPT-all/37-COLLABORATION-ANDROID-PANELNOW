package org.sopt.sopt_collaboration_panelnow.presentation.pointexchange

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.sopt.sopt_collaboration_panelnow.domain.entity.Product
import org.sopt.sopt_collaboration_panelnow.domain.repository.GoodsCheckRepository
import javax.inject.Inject

@HiltViewModel
class PointExchangeViewModel @Inject constructor(
    private val goodsCheckRepository: GoodsCheckRepository,
) : ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

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
}
