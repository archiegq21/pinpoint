import io.github.frankois944.spmForKmp.swiftPackageConfig

plugins {
    id("com.quibbly.shared.conventions")
}

kotlin {
    android {
        namespace = "com.quibbly.shared"
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
        it.swiftPackageConfig("shared") {
            minIos = libs.versions.ios.target.get()
        }
    }
    
    sourceSets {
        androidMain.dependencies {
        }
        commonMain.dependencies {
            implementation(projects.feature.auth)

            implementation(libs.kermit.crashlytics)

            implementation(libs.navigation3.ui)
            implementation(libs.navigation3.adaptive)
            implementation(libs.lifecycle.viewmodel.navigation3)
        }
        commonTest.dependencies {
        }
        iosMain.dependencies {
        }
    }
}

compose.resources {
    packageOfResClass = "com.quibbly.shared"
    generateResClass = always
    publicResClass = false
}