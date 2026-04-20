import io.github.frankois944.spmForKmp.swiftPackageConfig

plugins {
    id("com.quibbly.core.conventions")
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.serialization)
}

kotlin {
    android {
        namespace = "com.core.navigation"
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            baseName = "navigation"
            isStatic = true
        }
        it.swiftPackageConfig("navigation") {
            minIos = libs.versions.ios.target.get()
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.designsystem)

            implementation(libs.kotlinx.serialization.core)

            implementation(libs.navigation3.ui)
            implementation(libs.navigation3.adaptive)
            implementation(libs.lifecycle.viewmodel.navigation3)
        }
    }
}