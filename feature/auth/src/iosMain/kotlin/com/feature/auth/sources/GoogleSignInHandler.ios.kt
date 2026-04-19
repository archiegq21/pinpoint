package com.feature.auth.sources

import GoogleSignIn.GIDConfiguration
import GoogleSignIn.GIDSignIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.uikit.LocalUIViewController
import com.feature.auth.AuthConfig
import com.feature.auth.data.CredentialResult
import com.feature.auth.data.SignInException
import kotlinx.coroutines.suspendCancellableCoroutine
import platform.UIKit.UIViewController
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

internal class IosGoogleSignInHandler(
    private val gidSignIn: GIDSignIn,
    private val viewController: UIViewController,
): GoogleSignInHandler {

    override suspend fun getCredential(): CredentialResult = suspendCancellableCoroutine { continuation ->
        gidSignIn.signInWithPresentingViewController(viewController) { result, error ->
            val tokenId = result?.user?.idToken?.tokenString
            val accessToken = result?.user?.accessToken?.tokenString
            if (error == null && tokenId != null && accessToken != null) {
                val authCredential = CredentialResult(tokenId, accessToken)
                continuation.resume(authCredential)
            } else {
                continuation.resumeWithException(SignInException())
            }
        }
    }

}

@Composable
actual fun rememberGoogleSignInHandler(): GoogleSignInHandler {
    val gidSignIn = GIDSignIn.sharedInstance
    val viewController = LocalUIViewController.current
    return remember(gidSignIn, viewController) {
        gidSignIn.configuration = GIDConfiguration(AuthConfig.WEB_CLIENT_ID)
        IosGoogleSignInHandler(gidSignIn, viewController)
    }
}