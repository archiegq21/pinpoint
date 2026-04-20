package com.quibbly.shared

import GoogleMaps.GMSServices
import androidx.compose.ui.window.ComposeUIViewController
import com.feature.dashboard.DashboardConfig
import platform.UIKit.UIViewController

/**
 * Used on [:apps:pinpoint:iosApp]
 * */
@Suppress("unused", "FunctionName")
fun PinPointAppController(): UIViewController = ComposeUIViewController(
    configure = {
        GMSServices.provideAPIKey(DashboardConfig.MAP_KEY)
    }
) {
    PinPointApp()
}