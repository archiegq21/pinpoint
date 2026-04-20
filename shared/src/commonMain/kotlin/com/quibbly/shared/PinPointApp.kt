package com.quibbly.shared

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.core.designsystem.theme.CandyTheme
import com.core.navigation.rememberNavigator
import com.feature.api.auth.LoginNavKey
import com.feature.api.dashboard.MapNavKey
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun PinPointApp() {
    PinPointDependencyProvider {
        PinPointCoilSetup()
        CandyTheme(
            darkTheme = isSystemInDarkTheme(),
            dynamicColor = false,
        ) {
            val navigator = rememberNavigator(
                MapNavKey,
                configuration = Config,
            )

            PinPointNavigation(
                navigator = navigator,
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}