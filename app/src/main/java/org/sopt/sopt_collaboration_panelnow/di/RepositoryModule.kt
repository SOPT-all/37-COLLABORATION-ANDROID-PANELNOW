package org.sopt.sopt_collaboration_panelnow.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.sopt_collaboration_panelnow.data.repositoryimpl.GoodsCheckRepositoryImpl
import org.sopt.sopt_collaboration_panelnow.domain.repository.GoodsCheckRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    @Singleton
    fun bindsGoodsCheckRepository(goodsCheckRepositoryImpl: GoodsCheckRepositoryImpl): GoodsCheckRepository
}