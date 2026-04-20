import io.github.frankois944.spmForKmp.swiftPackageConfig

plugins {
    id("com.quibbly.feature.conventions")
    alias(libs.plugins.serialization)
}

kotlin {
    android {
        namespace = "com.feature.api.profile"
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            baseName = "apiprofile"
            isStatic = true
        }
        it.swiftPackageConfig("apiprofile") {
            minIos = libs.versions.ios.target.get()
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.navigation3.ui)
            implementation(libs.navigation3.adaptive)
            implementation(libs.lifecycle.viewmodel.navigation3)
        }
        commonTest.dependencies {
        }
    }
}

compose.resources {
    packageOfResClass = "com.feature.api.profile"
    generateResClass = always
    publicResClass = false
}