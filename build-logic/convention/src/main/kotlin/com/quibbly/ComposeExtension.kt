package com.quibbly

import org.gradle.api.Project
import org.gradle.kotlin.dsl.invoke
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

fun Project.configureCompose(
    extension: KotlinMultiplatformExtension
) = extension.apply {
    sourceSets {
        androidMain.dependencies {
            implementation(libs.findLibrary("ktor-client-android").get())
        }
        commonMain.dependencies {
            api(libs.findLibrary("compose-runtime").get())
            api(libs.findLibrary("compose-foundation").get())
            api(libs.findLibrary("compose-material3").get())
            api(libs.findLibrary("compose-ui").get())
            api(libs.findLibrary("compose-components-resources").get())
            api(libs.findLibrary("compose-components-preview").get())
            api(libs.findLibrary("compose-lifecycle").get())
            api(libs.findLibrary("compose-viewmodel").get())
            api(libs.findLibrary("lifecycle-common").get())
            api(libs.findLibrary("lifecycle-runtime").get())
            api(libs.findLibrary("window-size").get())
            api(libs.findLibrary("adaptive").get())

            implementation(libs.findLibrary("navigation3-ui").get())
            implementation(libs.findLibrary("navigation3-adaptive").get())
            implementation(libs.findLibrary("lifecycle-viewmodel-navigation3").get())

            api(project.dependencies.platform(libs.findLibrary("coil-bom").get()))
            api(libs.findLibrary("coil-compose").get())
            implementation(libs.findLibrary("coil-ktor").get())
        }
        commonTest.dependencies {
            implementation(libs.findLibrary("compose-ui-test").get())
        }
        iosMain.dependencies {
            implementation(libs.findLibrary("ktor-client-darwin").get())
        }
    }
}