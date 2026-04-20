package com.quibbly

import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

@Suppress("UnusedReceiverParameter")
internal fun Project.configureIos(
    extension: KotlinMultiplatformExtension
) = extension.apply {
    iosArm64()
    iosSimulatorArm64()
}