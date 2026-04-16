package com.quibbly.stackers

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.quibbly.shared.StackersApp


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        setContent {
            enableEdgeToEdge(
                statusBarStyle = SystemBarStyle.auto(
                    Color.argb(0xe6, 0xFF, 0xFF, 0xFF),
                    Color.argb(0x80, 0x1b, 0x1b, 0x1b)
                )
            )

            StackersApp()
        }
    }

}
