package org.sopt.sopt_collaboration_panelnow.data.remote.service

import org.sopt.sopt_collaboration_panelnow.data.remote.dto.BaseResponse
import org.sopt.sopt_collaboration_panelnow.data.remote.dto.response.GoodsCheckResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GoodsCheckService {
    @GET("products/{productId}")
    suspend fun getGoodsCheck(
        @Path("productId") productId: Int,
    ): BaseResponse<GoodsCheckResponse>
}