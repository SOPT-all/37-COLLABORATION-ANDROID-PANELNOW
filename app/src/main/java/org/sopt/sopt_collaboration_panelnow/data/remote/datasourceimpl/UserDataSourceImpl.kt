package org.sopt.sopt_collaboration_panelnow.data.remote.datasourceimpl

import org.sopt.sopt_collaboration_panelnow.data.remote.datasource.UserDataSource
import org.sopt.sopt_collaboration_panelnow.data.remote.dto.BaseResponse
import org.sopt.sopt_collaboration_panelnow.data.remote.dto.response.UserResponse
import org.sopt.sopt_collaboration_panelnow.data.remote.service.UserService
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(
    private val userService: UserService,
) : UserDataSource {
    override suspend fun getUser(userId: Long): BaseResponse<UserResponse> =
        userService.getPoint(userId)
}