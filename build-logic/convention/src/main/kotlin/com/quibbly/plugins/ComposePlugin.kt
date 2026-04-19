package com.quibbly.plugins

import com.quibbly.configureCompose
import com.quibbly.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

@Suppress("unused")
class ComposePlugin : Plugin<Project> {

    override fun apply(target: Project): Unit = with(target) {
        with(pluginManager) {
            apply(libs.findPlugin("android-library").get().get().pluginId)
            apply(libs.findPlugin("kotlin-multiplatform").get().get().pluginId)
            apply(libs.findPlugin("compose-multiplatform").get().get().pluginId)
            apply(libs.findPlugin("compose-compiler").get().get().pluginId)
        }

        extensions.configure<KotlinMultiplatformExtension> {
            configureCompose(this)
        }

        dependencies {
            "androidRuntimeClasspath"(libs.findLibrary("compose-preview-tooling").get())
        }
    }
}