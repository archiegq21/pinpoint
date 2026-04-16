package com.core.designsystem.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable


/**
 * iOS does not support dynamic ColorScheme
 * */
@Composable
internal actual fun dynamicColorScheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
): ColorScheme? = null
