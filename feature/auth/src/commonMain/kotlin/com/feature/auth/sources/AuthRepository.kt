package com.feature.auth.sources

interface AuthRepository {

    suspend fun signUp(email: String, password: String): String

    suspend fun login(email: String, password: String): String

}