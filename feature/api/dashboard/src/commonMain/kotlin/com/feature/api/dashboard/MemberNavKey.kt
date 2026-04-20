package com.feature.api.dashboard

import com.core.navigation.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object MemberNavKey: NavKey {
    override val isLoginRequired: Boolean = false
}