package com.feature.auth.sources

internal class RealAuthRepository(
    private val service: AuthService,
) : AuthRepository {

    override suspend fun signUp(email: String, password: String): String {
        return service.createUser(email = email, password = password)
    }

    override suspend fun login(email: String, password: String): String {
        return service.login(email = email, password = password)
    }

}