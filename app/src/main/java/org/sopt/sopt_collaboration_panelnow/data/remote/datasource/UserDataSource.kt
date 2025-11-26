package org.sopt.sopt_collaboration_panelnow.data.remote.datasource

import org.sopt.sopt_collaboration_panelnow.data.remote.dto.BaseResponse
import org.sopt.sopt_collaboration_panelnow.data.remote.dto.response.UserResponse

interface UserDataSource {
    suspend fun getUser(userId: Long) : BaseResponse<UserResponse>
}