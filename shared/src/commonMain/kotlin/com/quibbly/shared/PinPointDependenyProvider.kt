package com.quibbly.shared

import androidx.compose.runtime.Composable
import co.touchlab.kermit.Logger
import co.touchlab.kermit.koin.KermitKoinLogger
import com.core.utility.UtilityConfig
import com.feature.auth.di.authModule
import com.feature.profile.di.profileModule
import org.koin.compose.KoinApplication
import org.koin.core.logger.Level
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.koinConfiguration

@Composable
internal fun PinPointDependencyProvider(
    content: @Composable () -> Unit,
) {
    KoinApplication(
        configuration = koinConfiguration(declaration),
        logLevel = if (UtilityConfig.IS_DEBUG) Level.DEBUG else Level.NONE,
        content = content
    )
}

private val declaration: KoinAppDeclaration = {
    logger(KermitKoinLogger(Logger.withTag("koin")))
    modules(
        authModule,
        profileModule,
    )
}