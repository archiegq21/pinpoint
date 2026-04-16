package com.quibbly

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.assign
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

class KotlinMultiplatformPlugin: Plugin<Project> {

    override fun apply(target: Project):Unit = with(target){
        with(pluginManager){
            apply(libs.findPlugin("kotlin-multiplatform").get().get().pluginId)
        }

        extensions.configure<KotlinMultiplatformExtension> {
            compilerOptions.freeCompilerArgs.add("-Xexpect-actual-classes")

            jvmToolchain(libs.findVersion("jvm-target").get().requiredVersion.toInt())

            compilerOptions {
                languageVersion = KotlinVersion.KOTLIN_2_3
                freeCompilerArgs.add("-Xreturn-value-checker=full")
                freeCompilerArgs.add("-Xexplicit-backing-fields")
            }

            applyDefaultHierarchyTemplate()

            sourceSets.apply  {
                all {
                    languageSettings.optIn("kotlinx.cinterop.ExperimentalForeignApi")
                }
            }
        }
    }
}