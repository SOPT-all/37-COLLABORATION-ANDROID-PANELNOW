package org.sopt.sopt_collaboration_panelnow.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.sopt_collaboration_panelnow.data.remote.datasource.GoodsCheckDataSource
import org.sopt.sopt_collaboration_panelnow.data.remote.datasource.UserDataSource
import org.sopt.sopt_collaboration_panelnow.data.remote.datasourceimpl.GoodsCheckDataSourceImpl
import org.sopt.sopt_collaboration_panelnow.data.remote.datasourceimpl.UserDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {
    @Binds
    @Singleton
    fun bindsGoodsCheckDataSource(goodsCheckDataSourceImpl: GoodsCheckDataSourceImpl): GoodsCheckDataSource

    @Binds
    @Singleton
    fun bindsUserDataSource(userDataSourceImpl: UserDataSourceImpl): UserDataSource
}