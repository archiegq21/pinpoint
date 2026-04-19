package com.feature.auth.sources

import android.content.Context
import android.util.Base64
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.NoCredentialException
import com.feature.auth.AuthConfig
import com.feature.auth.data.CredentialResult
import com.feature.auth.data.SignInException
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential.Companion.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.security.SecureRandom

class AndroidGoogleSignInHandler(
    private val context: Context,
    private val credentialManager: CredentialManager,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : GoogleSignInHandler {

    override suspend fun getCredential(): CredentialResult {
        try {
            val option = GetGoogleIdOption.Builder()
                .setServerClientId(AuthConfig.WEB_CLIENT_ID)
                .setAutoSelectEnabled(true)
                .setFilterByAuthorizedAccounts(false)
                .setNonce(generateSecureRandomNonce())
                .build()

            val signInOption = GetSignInWithGoogleOption.Builder(AuthConfig.WEB_CLIENT_ID)
                .setNonce(generateSecureRandomNonce())
                .build()

            val request = GetCredentialRequest.Builder()
                .addCredentialOption(option)
                .addCredentialOption(signInOption)
                .setPreferImmediatelyAvailableCredentials(false)
                .build()

            val result = withContext(coroutineDispatcher) {
                credentialManager.getCredential(request = request, context = context)
            }

            val credential = result.credential
            if (credential is CustomCredential && credential.type == TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)
                return CredentialResult(
                    idToken = googleIdTokenCredential.idToken,
                    accessToken = null,
                )
            } else {
                throw SignInException()
            }
        } catch (e: NoCredentialException) {
            e.printStackTrace()
            throw SignInException()
        }
    }

    private fun generateSecureRandomNonce(byteLength: Int = 32): String {
        val randomBytes = ByteArray(byteLength)
        SecureRandom().nextBytes(randomBytes)
        return Base64.encodeToString(
            randomBytes,
            Base64.NO_WRAP or Base64.URL_SAFE or Base64.NO_PADDING
        )
    }

}

@Composable
actual fun rememberGoogleSignInHandler(): GoogleSignInHandler {
    val context = LocalContext.current
    val credentialManager = CredentialManager.create(context)
    return remember(context) {
        AndroidGoogleSignInHandler(
            context = context,
            credentialManager = credentialManager,
        )
    }
}