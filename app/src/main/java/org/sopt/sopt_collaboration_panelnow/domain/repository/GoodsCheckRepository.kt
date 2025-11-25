package org.sopt.sopt_collaboration_panelnow.domain.repository

import org.sopt.sopt_collaboration_panelnow.domain.entity.GoodsCheck
import org.sopt.sopt_collaboration_panelnow.domain.entity.Product

interface GoodsCheckRepository {
    suspend fun getProducts(sort: String): Result<List<Product>>
    suspend fun getGoodsCheck(productId: Int): Result<GoodsCheck>
    suspend fun postPurchase(userId: Long, productId: Int): Result<String>
}