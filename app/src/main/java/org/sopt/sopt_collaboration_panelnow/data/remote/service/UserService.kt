package org.sopt.sopt_collaboration_panelnow.data.remote.service

import org.sopt.sopt_collaboration_panelnow.data.remote.dto.BaseResponse
import org.sopt.sopt_collaboration_panelnow.data.remote.dto.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface UserService {
    @GET("users")
    suspend fun getPoint(
        @Header("userId") userId: Long
    ): BaseResponse<UserResponse>
}