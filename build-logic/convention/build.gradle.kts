plugins {
    `kotlin-dsl`
}

group = "com.quibbly"

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
}

dependencies {
    compileOnly(libs.agp)
    compileOnly(libs.compose.multiplatform)
    compileOnly(libs.kmm.gradle.plugin)
    compileOnly(libs.spm4kmm)
}

gradlePlugin {
    plugins {
        register("kotlin-conventions") {
            id = "com.quibbly.kmp"
            implementationClass = "com.quibbly.plugins.KotlinMultiplatformPlugin"
        }
        register("core-kotlin-conventions") {
            id = "com.quibbly.core.conventions"
            implementationClass = "com.quibbly.plugins.CorePlugin"
        }
        register("feature-kotlin-conventions") {
            id = "com.quibbly.feature.conventions"
            implementationClass = "com.quibbly.plugins.FeaturePlugin"
        }
        register("shared-kotlin-conventions") {
            id = "com.quibbly.shared.conventions"
            implementationClass = "com.quibbly.plugins.SharedPlugin"
        }
        register("compose-kotlin-conventions") {
            id = "com.quibbly.compose.conventions"
            implementationClass = "com.quibbly.plugins.ComposePlugin"
        }
    }
}
