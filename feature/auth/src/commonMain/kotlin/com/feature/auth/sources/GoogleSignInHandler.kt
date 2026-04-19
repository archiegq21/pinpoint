package com.feature.auth.sources

import androidx.compose.runtime.Composable
import com.feature.auth.data.CredentialResult

interface GoogleSignInHandler {
    suspend fun getCredential(): CredentialResult
}

@Composable
expect fun rememberGoogleSignInHandler(): GoogleSignInHandler