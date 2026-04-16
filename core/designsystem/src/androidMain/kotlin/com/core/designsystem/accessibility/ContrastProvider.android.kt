package com.core.designsystem.accessibility

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.LifecycleResumeEffect

@Composable
actual fun rememberContrastProvider(): ContrastProvider {
    val context = LocalContext.current
    val contextProvider = remember(context) {
        AndroidContrastProvider(context)
    }

    LifecycleResumeEffect(contextProvider) {
        contextProvider.startListener()
        onPauseOrDispose {
            contextProvider.endListener()
        }
    }

    return contextProvider
}