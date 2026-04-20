package com.feature.auth

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.metadata
import com.core.navigation.NavKey
import com.core.navigation.decorator.MainTopBarAppSceneDecoratorStrategy.Companion.mainView
import com.feature.api.auth.LoginNavKey
import com.feature.api.auth.SignUpNavKey
import com.feature.auth.ui.LoginRoute
import com.feature.auth.ui.SignUpRoute
import kotlinx.serialization.modules.PolymorphicModuleBuilder

fun PolymorphicModuleBuilder<NavKey>.authNavKeySerializers() {
    subclass(LoginNavKey::class, LoginNavKey.serializer())
    subclass(SignUpNavKey::class, SignUpNavKey.serializer())
}

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
fun EntryProviderScope<NavKey>.authEntryBuilder() {
    entry<LoginNavKey> {
        LoginRoute(
            modifier = Modifier.fillMaxSize(),
            onLoginClick = { _, _ ->},
            onSignUpClick = {},
            onGoogleSignInClick = {},
        )
    }
    entry<SignUpNavKey> {
        SignUpRoute(
            modifier = Modifier.fillMaxSize(),
            onSignUpClick = { _, _, _ ->},
            onLoginClick = {},
        )
    }
}