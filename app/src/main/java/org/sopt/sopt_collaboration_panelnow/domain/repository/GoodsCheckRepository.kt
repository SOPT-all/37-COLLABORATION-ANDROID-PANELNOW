package org.sopt.sopt_collaboration_panelnow.domain.repository

import org.sopt.sopt_collaboration_panelnow.domain.entity.GoodsCheck

interface GoodsCheckRepository {
    suspend fun getGoodsCheck(productId: Int): Result<GoodsCheck>
    suspend fun postPurchase(userId: Long, productId: Int): Result<String>
}