package com.feature.api.dashboard

import com.core.navigation.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object MapNavKey: NavKey {
    override val isLoginRequired: Boolean = true
}