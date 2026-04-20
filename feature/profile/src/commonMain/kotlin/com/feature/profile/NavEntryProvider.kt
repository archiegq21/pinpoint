package com.feature.profile

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.metadata
import com.core.navigation.NavKey
import com.core.navigation.Navigator
import com.core.navigation.decorator.MainTopBarAppSceneDecoratorStrategy.Companion.mainView
import com.feature.api.profile.ProfileNavKey
import com.feature.profile.ui.ProfileRoute
import kotlinx.serialization.modules.PolymorphicModuleBuilder

fun PolymorphicModuleBuilder<NavKey>.profileNavKeySerializers() {
    subclass(ProfileNavKey::class, ProfileNavKey.serializer())
}

fun EntryProviderScope<NavKey>.profileEntryBuilder() {
    entry<ProfileNavKey>(
        metadata = metadata {
            mainView()
        },
    ) {
        ProfileRoute(
            onSignOutClick = {},
            modifier = Modifier.fillMaxSize(),
        )
    }
}

fun Navigator.navigateToProfile() {
    goTo(ProfileNavKey)
}