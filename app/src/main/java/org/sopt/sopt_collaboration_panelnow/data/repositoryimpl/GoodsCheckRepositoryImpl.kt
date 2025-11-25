package org.sopt.sopt_collaboration_panelnow.data.repositoryimpl

import org.sopt.sopt_collaboration_panelnow.data.mapper.toGoodsCheck
import org.sopt.sopt_collaboration_panelnow.data.mapper.toProduct
import org.sopt.sopt_collaboration_panelnow.data.remote.datasource.GoodsCheckDataSource
import org.sopt.sopt_collaboration_panelnow.domain.entity.GoodsCheck
import org.sopt.sopt_collaboration_panelnow.domain.entity.Product
import org.sopt.sopt_collaboration_panelnow.domain.repository.GoodsCheckRepository
import javax.inject.Inject

class GoodsCheckRepositoryImpl @Inject constructor(
    private val goodsCheckDataSource: GoodsCheckDataSource,
) : GoodsCheckRepository {
    override suspend fun getProducts(sort: String): Result<List<Product>> {
        return runCatching {
            goodsCheckDataSource.getProducts(sort).data.map { it.toProduct() }
        }
    }
    override suspend fun getGoodsCheck(productId: Int): Result<GoodsCheck> {
        return runCatching {
            goodsCheckDataSource.getGoodsCheck(productId).data.toGoodsCheck()
        }
    }

    override suspend fun postPurchase(userId: Long, productId: Int): Result<String> {
        return runCatching {
            val response = goodsCheckDataSource.postPurchase(userId, productId)
            response.message
        }
    }
}