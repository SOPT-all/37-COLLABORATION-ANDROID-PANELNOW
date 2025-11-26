package org.sopt.sopt_collaboration_panelnow.domain.repository

import org.sopt.sopt_collaboration_panelnow.domain.entity.User

interface UserRepository {
    suspend fun getUser(userId: Long) : Result<User>
}