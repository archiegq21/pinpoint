package com.quibbly

import com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryTarget
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

internal fun Project.configureAndroid(
    extension: KotlinMultiplatformAndroidLibraryTarget
) = extension.apply {
    compileSdk = libs.findVersion("android-compileSdk").get().requiredVersion.toInt()
    minSdk = libs.findVersion("android-minSdk").get().requiredVersion.toInt()

    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
    }

    androidResources {
        enable = true
    }
}