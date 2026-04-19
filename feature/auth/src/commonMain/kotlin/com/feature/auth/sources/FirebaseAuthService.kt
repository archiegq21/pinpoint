package com.feature.auth.sources

import com.feature.auth.data.EmailAlreadyInUseException
import com.feature.auth.data.InvalidCredentialsException
import com.feature.auth.data.InvalidEmailException
import com.feature.auth.data.InvalidUserException
import com.feature.auth.data.WeakPasswordException
import dev.gitlive.firebase.auth.AuthCredential
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.FirebaseAuthInvalidCredentialsException
import dev.gitlive.firebase.auth.FirebaseAuthInvalidUserException
import dev.gitlive.firebase.auth.FirebaseAuthUserCollisionException
import dev.gitlive.firebase.auth.FirebaseAuthWeakPasswordException
import dev.gitlive.firebase.auth.GoogleAuthProvider

internal class FirebaseAuthService(
    private val firebaseAuth: FirebaseAuth,
) : AuthService {

    override suspend fun createUser(email: String, password: String): String {
        try {
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password)
            return result.user!!.uid
        } catch (_: FirebaseAuthWeakPasswordException) {
            throw WeakPasswordException()
        } catch (_: FirebaseAuthInvalidCredentialsException) {
            throw InvalidEmailException()
        } catch (_: FirebaseAuthUserCollisionException) {
            throw EmailAlreadyInUseException()
        } catch (_: Exception) {
            throw Exception()
        }
    }

    override suspend fun login(email: String, password: String): String {
        try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password)
            return result.user!!.uid
        } catch (_: FirebaseAuthInvalidUserException) {
            throw InvalidUserException()
        } catch (_: FirebaseAuthInvalidCredentialsException) {
            throw InvalidCredentialsException()
        } catch (_: Exception) {
            throw Exception()
        }
    }

    override suspend fun loginWithGoogle(idToken: String, accessToken: String?): String {
        val credential = GoogleAuthProvider.credential(idToken, accessToken)
        return loginWithCredential(credential)
    }

    private suspend fun loginWithCredential(credential: AuthCredential): String {
        try {
            val result = firebaseAuth.signInWithCredential(credential)
            return result.user!!.uid
        } catch (_: FirebaseAuthInvalidUserException) {
            throw InvalidUserException()
        } catch (_: FirebaseAuthInvalidCredentialsException) {
            throw InvalidCredentialsException()
        } catch (_: FirebaseAuthUserCollisionException) {
            throw EmailAlreadyInUseException()
        } catch (_: Exception) {
            throw Exception()
        }
    }

}