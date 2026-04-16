package com.quibbly

import io.github.frankois944.spmForKmp.swiftPackageConfig
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.configureIos(
    name: () -> String,
    extension: KotlinMultiplatformExtension
) = extension.apply {
    iosArm64()
    iosSimulatorArm64()

    afterEvaluate {
        targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
            binaries.framework {
                baseName = name()
                isStatic = true
            }
            swiftPackageConfig(name()) {
                minIos = libs.findVersion("ios-target").get().preferredVersion
            }
        }
    }
}