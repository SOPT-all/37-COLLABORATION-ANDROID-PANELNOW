package org.sopt.sopt_collaboration_panelnow.data.repositoryimpl

import org.sopt.sopt_collaboration_panelnow.data.mapper.toUser
import org.sopt.sopt_collaboration_panelnow.data.remote.datasource.UserDataSource
import org.sopt.sopt_collaboration_panelnow.domain.entity.User
import org.sopt.sopt_collaboration_panelnow.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userService: UserDataSource,
) : UserRepository {
    override suspend fun getUser(userId: Long): Result<User> {
        return runCatching {
            userService.getUser(userId).data.toUser()
        }
    }
}
