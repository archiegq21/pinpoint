package com.feature.api.auth

import com.core.navigation.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object LoginNavKey: NavKey {
    override val isLoginRequired: Boolean = false
}
