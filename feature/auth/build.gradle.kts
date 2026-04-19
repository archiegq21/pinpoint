import com.codingfeline.buildkonfig.compiler.FieldSpec.Type
import com.quibbly.Environment
import com.quibbly.Keys
import io.github.frankois944.spmForKmp.swiftPackageConfig
import org.gradle.kotlin.dsl.libs
import org.jetbrains.kotlin.konan.properties.Properties
import kotlin.apply

plugins {
    id("com.quibbly.feature.conventions")
    alias(libs.plugins.serialization)
    alias(libs.plugins.buildconfig)
}

val keyStoreProperties =
    readProperties(file(projectDir.resolve("../../keys/keystore.properties")))

kotlin {
    android {
        namespace = "com.feature.auth"
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            baseName = "auth"
            isStatic = true
        }
        it.swiftPackageConfig("auth") {
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
                remotePackageVersion(
                    url = uri("https://github.com/google/GoogleSignIn-iOS"),
                    products = {
                        add("GoogleSignIn", exportToKotlin = true)
                        add("GoogleSignInSwift", exportToKotlin = true)
                    },
                    version = "9.1.0",
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
            api(projects.feature.api.auth)

            implementation(libs.firebase.kmm.auth)

            implementation(libs.compottie)

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
    packageOfResClass = "com.feature.auth"
    generateResClass = always
    publicResClass = false
}

buildkonfig {
    packageName = "com.feature.auth"
    exposeObjectWithName = "AuthConfig"

    defaultConfigs {}
    targetConfigs(Environment.DEBUG.value) {
        create(com.quibbly.Platform.IOS.value) {
            buildConfigField(Type.STRING, Keys.WEB_CLIENT_ID, keyStoreProperties.getProperty(Keys.IOS_WEB_CLIENT_ID_DEV))
        }
        create(com.quibbly.Platform.ANDROID.value) {
            buildConfigField(Type.STRING, Keys.WEB_CLIENT_ID, keyStoreProperties.getProperty(Keys.ANDROID_WEB_CLIENT_ID_DEV))
        }
    }
    targetConfigs(Environment.RELEASE.value) {
        create(com.quibbly.Platform.IOS.value) {
            buildConfigField(Type.STRING, Keys.WEB_CLIENT_ID, keyStoreProperties.getProperty(Keys.IOS_WEB_CLIENT_ID_PROD))
        }
        create(com.quibbly.Platform.ANDROID.value) {
            buildConfigField(Type.STRING, Keys.WEB_CLIENT_ID, keyStoreProperties.getProperty(Keys.ANDROID_WEB_CLIENT_ID_PROD))
        }
    }
}

private fun readProperties(propertiesFile: File) = Properties().apply {
    propertiesFile.inputStream().use { fis ->
        load(fis)
    }
}