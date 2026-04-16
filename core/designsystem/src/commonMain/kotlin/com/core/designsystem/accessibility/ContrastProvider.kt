package com.core.designsystem.accessibility

import androidx.compose.runtime.Composable


@Composable
expect fun rememberContrastProvider(): ContrastProvider

interface ContrastProvider {
    val contrastLevel: Level

    enum class Level {
        DEFAULT, MEDIUM, HIGH
    }
}