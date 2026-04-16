import io.github.frankois944.spmForKmp.swiftPackageConfig
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.serialization)
    alias(libs.plugins.spm4kmm)
    alias(libs.plugins.mockkery)
    id("com.quibbly.kmp")
}

kotlin {
    android {
        namespace = "com.quibbly.shared"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }

        androidResources {
            enable = true
        }
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
        @Suppress("OPT_IN_USAGE")
        iosTarget.swiftPackageConfig("shared") {
            minIos = libs.versions.ios.target.get()
        }
    }
    
    sourceSets {
        androidMain.dependencies {
        }
        commonMain.dependencies {
        }
        commonTest.dependencies {
        }
        iosMain.dependencies {
        }
    }
}

dependencies {
    "androidRuntimeClasspath"(libs.compose.preview.tooling)
}

//compose.resources {
//    packageOfResClass = "com.quibbly.shared"
//    generateResClass = always
//    publicResClass = false
//}