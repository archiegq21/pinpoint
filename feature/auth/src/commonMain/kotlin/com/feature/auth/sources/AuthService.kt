package com.feature.auth.sources

interface AuthService {

    suspend fun createUser(email: String, password: String): String

    suspend fun login(email: String, password: String): String

    suspend fun loginWithGoogle(idToken: String, accessToken: String?): String

}