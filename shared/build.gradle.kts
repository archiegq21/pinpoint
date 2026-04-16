plugins {
    id("com.quibbly.shared.conventions")
}

sharedConfig {
    name = "shared"
}

kotlin {
    android {
        namespace = "com.quibbly.shared"
    }
    
    sourceSets {
        androidMain.dependencies {
        }
        commonMain.dependencies {
            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(libs.koin.core)
            implementation(libs.koin.compose)

            implementation(libs.kermit)
            implementation(libs.kermit.koin)
            implementation(libs.kermit.crashlytics)
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