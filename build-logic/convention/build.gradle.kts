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
    compileOnly(libs.kmm.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("stackers-kotlin-conventions") {
            id = "com.quibbly.kmp"
            implementationClass = "com.quibbly.KotlinMultiplatformPlugin"
        }
    }
}
