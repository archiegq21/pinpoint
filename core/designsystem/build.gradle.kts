import io.github.frankois944.spmForKmp.swiftPackageConfig

plugins {
    id("com.quibbly.core.conventions")
    id("com.quibbly.compose.conventions")
    alias(libs.plugins.serialization)
}

kotlin {
    android {
        namespace = "com.core.designsystem"
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            baseName = "designsystem"
            isStatic = true
        }
        it.swiftPackageConfig("designsystem") {
            minIos = libs.versions.ios.target.get()
        }
    }
}

compose.resources {
    packageOfResClass = "com.core.designsystem"
    generateResClass = always
    publicResClass = true
}