package org.sopt.sopt_collaboration_panelnow.data.remote.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    @SerialName("currentPoint")
    val currentPoint: Int,
    @SerialName("usedPoint")
    val usedPoint: Int,
)