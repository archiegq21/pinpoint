import io.github.frankois944.spmForKmp.swiftPackageConfig

plugins {
    id("com.quibbly.feature.conventions")
    alias(libs.plugins.serialization)
}

kotlin {
    android {
        namespace = "com.feature.profile"
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            baseName = "profile"
            isStatic = true
        }
        it.swiftPackageConfig("profile") {
            minIos = libs.versions.ios.target.get()
            dependency {
                remotePackageVersion(
                    url = uri("https://github.com/firebase/firebase-ios-sdk"),
                    products = {
                        add("FirebaseCore")
                        add("FirebaseAuth")
                    },
                    version = "12.12.0",
                )
            }
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.credentials)
            implementation(libs.credentials.play.auth)
            implementation(libs.identity)

            implementation(project.dependencies.platform(libs.firebase.bom))
            implementation(libs.firebase.auth)
        }
        commonMain.dependencies {
            api(projects.feature.api.profile)

            implementation(libs.firebase.kmm.auth)

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
    packageOfResClass = "com.feature.profile"
    generateResClass = always
    publicResClass = false
}