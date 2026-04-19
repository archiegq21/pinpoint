package com.quibbly.shared

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import com.core.designsystem.theme.CandyTheme
import com.feature.api.auth.LoginNavKey


@Composable
fun PinPointApp() {
    val backStack: NavBackStack<NavKey> = rememberNavBackStack(Config, LoginNavKey)

    PinPointDependencyProvider {
        CandyTheme(
            darkTheme = isSystemInDarkTheme(),
            dynamicColor = false,
        ) {
            PinPointNavigation(
                backStack = backStack,
                onBack = { backStack.removeLastOrNull() },
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}