package com.feature.api.auth

import com.core.navigation.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object SignUpNavKey: NavKey {
    override val isLoginRequired: Boolean = false
}