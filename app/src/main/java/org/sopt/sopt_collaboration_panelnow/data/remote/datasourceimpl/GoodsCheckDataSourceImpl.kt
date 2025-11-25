package org.sopt.sopt_collaboration_panelnow.data.remote.datasourceimpl

import org.sopt.sopt_collaboration_panelnow.data.remote.datasource.GoodsCheckDataSource
import org.sopt.sopt_collaboration_panelnow.data.remote.dto.BaseResponse
import org.sopt.sopt_collaboration_panelnow.data.remote.dto.response.GoodsCheckResponse
import org.sopt.sopt_collaboration_panelnow.data.remote.service.GoodsCheckService
import javax.inject.Inject

class GoodsCheckDataSourceImpl @Inject constructor(
    private val goodsCheckService: GoodsCheckService,
) : GoodsCheckDataSource {
    override suspend fun getGoodsCheck(productId: Int): BaseResponse<GoodsCheckResponse> =
        goodsCheckService.getGoodsCheck(productId)
}