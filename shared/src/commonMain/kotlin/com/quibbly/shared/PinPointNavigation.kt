package com.quibbly.shared

import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.scene.SinglePaneSceneStrategy
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.feature.auth.authEntryBuilder
import com.feature.auth.authNavKeySerializers
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic


internal val Config = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            authNavKeySerializers()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3AdaptiveApi::class)
@Composable
internal fun PinPointNavigation(
    backStack: NavBackStack<NavKey>,
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    SharedTransitionLayout {
        NavDisplay(
            modifier = modifier,
            backStack = backStack,
            onBack = onBack,
            sharedTransitionScope = this@SharedTransitionLayout,
            sceneStrategies = listOf(
                SinglePaneSceneStrategy()
            ),
            sceneDecoratorStrategies = listOf(),
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator(),
            ),
            entryProvider = entryProvider {
                authEntryBuilder()
            }
        )
    }
}