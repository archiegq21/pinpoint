package com.quibbly.shared

import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.scene.SinglePaneSceneStrategy
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.core.navigation.NavKey
import com.core.navigation.Navigator
import com.core.navigation.decorator.rememberMainTopBarAppSceneDecoratorStrategy
import com.feature.auth.authEntryBuilder
import com.feature.auth.authNavKeySerializers
import com.feature.dashboard.dashboardEntryBuilder
import com.feature.dashboard.dashboardNavKeySerializers
import com.feature.profile.component.ProfileImage
import com.feature.profile.navigateToProfile
import com.feature.profile.profileEntryBuilder
import com.feature.profile.profileNavKeySerializers
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

internal val Config = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            authNavKeySerializers()
            dashboardNavKeySerializers()
            profileNavKeySerializers()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PinPointNavigation(
    navigator: Navigator,
    modifier: Modifier = Modifier,
) {
    SharedTransitionLayout {
        val mainTopBarSceneDecorator = rememberMainTopBarAppSceneDecoratorStrategy<NavKey>(
            topBar = {
                TopAppBar(
                    title = {},
                    modifier = Modifier.fillMaxWidth(),
                    actions = {
                        ProfileImage(
                            profileImageUrl = null,
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(48.dp)
                                .clickable { navigator.navigateToProfile() },
                        )
                    }
                )
            }
        )

        NavDisplay(
            modifier = modifier,
            backStack = navigator,
            onBack = navigator::goBack,
            sharedTransitionScope = this@SharedTransitionLayout,
            sceneStrategies = listOf(
                SinglePaneSceneStrategy()
            ),
            sceneDecoratorStrategies = listOf(
                mainTopBarSceneDecorator,
            ),
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator(),
            ),
            entryProvider = entryProvider {
                authEntryBuilder()
                dashboardEntryBuilder()
                profileEntryBuilder()
            }
        )
    }
}