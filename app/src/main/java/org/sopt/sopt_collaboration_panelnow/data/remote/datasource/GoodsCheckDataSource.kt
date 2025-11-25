package org.sopt.sopt_collaboration_panelnow.data.remote.datasource

import org.sopt.sopt_collaboration_panelnow.data.remote.dto.BaseResponse
import org.sopt.sopt_collaboration_panelnow.data.remote.dto.response.GoodsCheckResponse

interface GoodsCheckDataSource {
    suspend fun getGoodsCheck(productId: Int): BaseResponse<GoodsCheckResponse>
}