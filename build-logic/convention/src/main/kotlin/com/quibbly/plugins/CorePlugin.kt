package com.quibbly.plugins

import com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryTarget
import com.quibbly.configureAndroid
import com.quibbly.configureIos
import com.quibbly.configureKotlinMultiplatform
import com.quibbly.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

@Suppress("unused")
class CorePlugin: Plugin<Project> {

    override fun apply(target: Project):Unit = with(target){
        with(pluginManager){
            apply(libs.findPlugin("android-library").get().get().pluginId)
            apply(libs.findPlugin("kotlin-multiplatform").get().get().pluginId)
            apply(libs.findPlugin("spm4kmm").get().get().pluginId)
        }

        val extension = project.extensions.create("coreConfig", CoreConventionExtension::class.java)

        extensions.configure<KotlinMultiplatformExtension> {
            configureKotlinMultiplatform(this)

            configureIos({ extension.name.get() }, this)

            configure<KotlinMultiplatformAndroidLibraryTarget> {
                configureAndroid(this)
            }
        }
    }
}

interface CoreConventionExtension {
    val name: Property<String>
}