package org.sopt.sopt_collaboration_panelnow.data.mapper

import org.sopt.sopt_collaboration_panelnow.data.remote.dto.response.UserResponse
import org.sopt.sopt_collaboration_panelnow.domain.entity.User

fun UserResponse.toUser() = User(
    currentPoint = this.currentPoint,
    usedPoint = this.usedPoint
)