package com.feature.api.profile

import com.core.navigation.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object ProfileNavKey: NavKey {
    override val isLoginRequired: Boolean = true
}