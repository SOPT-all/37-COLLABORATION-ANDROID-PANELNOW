package org.sopt.sopt_collaboration_panelnow.data.remote.datasource

import org.sopt.sopt_collaboration_panelnow.data.remote.dto.BaseResponse
import org.sopt.sopt_collaboration_panelnow.data.remote.dto.response.GoodsCheckResponse
import org.sopt.sopt_collaboration_panelnow.data.remote.dto.response.PurchaseResponse

interface GoodsCheckDataSource {
    suspend fun getGoodsCheck(productId: Int): BaseResponse<GoodsCheckResponse>
    suspend fun postPurchase(userId: Long, productId: Int): BaseResponse<PurchaseResponse>
}