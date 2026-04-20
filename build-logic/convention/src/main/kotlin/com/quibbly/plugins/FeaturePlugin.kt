package com.quibbly.plugins

import com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryTarget
import com.quibbly.configureAndroid
import com.quibbly.configureIos
import com.quibbly.configureKotlinMultiplatform
import com.quibbly.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.invoke
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

@Suppress("unused")
class FeaturePlugin: Plugin<Project> {

    override fun apply(target: Project):Unit = with(target){
        with(pluginManager){
            apply(libs.findPlugin("android-library").get().get().pluginId)
            apply(libs.findPlugin("kotlin-multiplatform").get().get().pluginId)
            apply(libs.findPlugin("compose-multiplatform").get().get().pluginId)
            apply(libs.findPlugin("compose-compiler").get().get().pluginId)
            apply(libs.findPlugin("serialization").get().get().pluginId)
            apply(libs.findPlugin("spm4kmm").get().get().pluginId)
        }

        extensions.configure<KotlinMultiplatformExtension> {
            configureKotlinMultiplatform(this)

            configureIos(this)

            configure<KotlinMultiplatformAndroidLibraryTarget> {
                configureAndroid(this)
            }

            sourceSets {
                androidMain.dependencies {
                    implementation(libs.findLibrary("koin-android").get())
                }
                commonMain.dependencies {
                    implementation(project(":core:navigation"))
                    implementation(project(":core:designsystem"))
                    implementation(project(":core:utility"))

                    implementation(project.dependencies.platform(libs.findLibrary("koin-bom").get()))
                    implementation(libs.findLibrary("koin-core").get())
                    implementation(libs.findLibrary("koin-compose").get())
                    implementation(libs.findLibrary("koin-compose-viewmodel").get())
                    implementation(libs.findLibrary("koin-compose-viewmodel-navigation").get())
                    implementation(libs.findLibrary("koin-compose-navigation3").get())

                    implementation(libs.findLibrary("kotlinx-serialization-core").get())

                    implementation(libs.findLibrary("kermit").get())
                }
                commonTest.dependencies {
                    implementation(libs.findLibrary("koin-test").get())
                    implementation(libs.findLibrary("compose-ui-test").get())
                }
            }
        }

        dependencies {
            "androidRuntimeClasspath"(libs.findLibrary("compose-preview-tooling").get())
        }
    }
}