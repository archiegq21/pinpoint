package com.quibbly.shared

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

/**
 * Used on [:apps:pinpoint:iosApp]
 * */
@Suppress("unused", "FunctionName")
fun PinPointAppController(): UIViewController = ComposeUIViewController {
    PinPointApp()
}