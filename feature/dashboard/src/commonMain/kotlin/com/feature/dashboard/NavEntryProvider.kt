package com.feature.dashboard

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.metadata
import com.core.navigation.NavKey
import com.core.navigation.decorator.MainTopBarAppSceneDecoratorStrategy.Companion.mainView
import com.feature.api.dashboard.MapNavKey
import com.feature.api.dashboard.MemberNavKey
import com.feature.dashboard.ui.MapRoute
import kotlinx.serialization.modules.PolymorphicModuleBuilder

fun PolymorphicModuleBuilder<NavKey>.dashboardNavKeySerializers() {
    subclass(MapNavKey::class, MapNavKey.serializer())
    subclass(MemberNavKey::class, MemberNavKey.serializer())
}

fun EntryProviderScope<NavKey>.dashboardEntryBuilder() {
    entry<MapNavKey>(
        metadata = metadata {
            mainView()
        },
    ) {
        MapRoute(
            modifier = Modifier.fillMaxSize(),
        )
    }
}