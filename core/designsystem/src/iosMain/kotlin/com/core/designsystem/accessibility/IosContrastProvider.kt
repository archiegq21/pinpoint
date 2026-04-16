package com.core.designsystem.accessibility

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import platform.Foundation.NSNotificationCenter
import platform.Foundation.NSOperationQueue
import platform.UIKit.UIAccessibilityDarkerSystemColorsEnabled
import platform.UIKit.UIAccessibilityDarkerSystemColorsStatusDidChangeNotification
import platform.darwin.NSObjectProtocol

internal class IosContrastProvider: ContrastProvider {
    override var contrastLevel by mutableStateOf(getCurrentContrastLevel())
        private set

    private var token: NSObjectProtocol? = null

    fun startListener() {
        contrastLevel = getCurrentContrastLevel()
        token = NSNotificationCenter.defaultCenter.addObserverForName(
            UIAccessibilityDarkerSystemColorsStatusDidChangeNotification,
            `object` = null,
            queue = NSOperationQueue.mainQueue
        ) {
            contrastLevel = getCurrentContrastLevel()
        }
    }

    fun endListener() {
        if (token == null) return
        NSNotificationCenter.defaultCenter.removeObserver(token!!)
    }

    private fun getCurrentContrastLevel(): ContrastProvider.Level {
        if (UIAccessibilityDarkerSystemColorsEnabled()) {
            return ContrastProvider.Level.HIGH
        }
        return ContrastProvider.Level.DEFAULT
    }
}