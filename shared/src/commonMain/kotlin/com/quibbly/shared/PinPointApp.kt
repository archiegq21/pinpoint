package com.quibbly.shared

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.core.designsystem.theme.CandyTheme


@Composable
fun PinPointApp() {
    PinPointDependencyProvider {
        CandyTheme(
            darkTheme = isSystemInDarkTheme(),
            dynamicColor = false,
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text("Hello")
            }
        }
    }
}