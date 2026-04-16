package com.core.designsystem.accessibility

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.LifecycleResumeEffect

@Composable
actual fun rememberContrastProvider(): ContrastProvider {
    val contextProvider = remember { IosContrastProvider() }

    LifecycleResumeEffect(contextProvider) {
        contextProvider.startListener()
        onPauseOrDispose {
            contextProvider.endListener()
        }
    }

    return contextProvider
}