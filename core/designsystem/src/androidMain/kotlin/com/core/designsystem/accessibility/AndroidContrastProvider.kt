package com.core.designsystem.accessibility

import android.app.UiModeManager
import android.content.Context
import android.os.Build
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.content.ContextCompat


internal class AndroidContrastProvider(
    private val context: Context,
) : ContrastProvider {

    override var contrastLevel by mutableStateOf(getCurrentContrastLevel())
        private set

    private val uiNodeManager: UiModeManager by lazy {
        context.getSystemService(Context.UI_MODE_SERVICE) as UiModeManager
    }

    private var listener: UiModeManager.ContrastChangeListener? = null

    fun startListener() {
        if (!isContrastAvailable()) return

        contrastLevel = getCurrentContrastLevel()
        listener = UiModeManager.ContrastChangeListener {
            contrastLevel = getCurrentContrastLevel()
        }

        uiNodeManager.addContrastChangeListener(
            ContextCompat.getMainExecutor(context),
            listener!!
        )
    }

    fun endListener() {
        if (!isContrastAvailable()) return
        uiNodeManager.removeContrastChangeListener(listener!!)
    }

    private fun getCurrentContrastLevel(): ContrastProvider.Level {
        if (isContrastAvailable()) {
            val uiModeManager = context.getSystemService(Context.UI_MODE_SERVICE) as UiModeManager
            val contrast = uiModeManager.contrast
            return when (contrast) {
                in 0.0f..0.33f -> ContrastProvider.Level.DEFAULT
                in 0.34f..0.66f -> ContrastProvider.Level.MEDIUM
                in 0.67f..1.0f -> ContrastProvider.Level.HIGH
                else -> ContrastProvider.Level.DEFAULT
            }
        }
        return ContrastProvider.Level.DEFAULT
    }

    private fun isContrastAvailable(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE
    }
}