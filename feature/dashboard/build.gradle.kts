import com.codingfeline.buildkonfig.compiler.FieldSpec.Type
import com.quibbly.Environment
import com.quibbly.Keys
import io.github.frankois944.spmForKmp.swiftPackageConfig
import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    id("com.quibbly.feature.conventions")
    alias(libs.plugins.serialization)
    alias(libs.plugins.buildconfig)
}

val keyStoreProperties =
    readProperties(file(projectDir.resolve("../../keys/keystore.properties")))

kotlin {
    android {
        namespace = "com.feature.dashboard"
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            baseName = "dashboard"
            isStatic = true
        }
        it.swiftPackageConfig("dashboard") {
            minIos = libs.versions.ios.target.get()
        }
    }

    sourceSets {
        commonMain.dependencies {
            api(projects.feature.api.dashboard)

            implementation(libs.maps.kmm)

            implementation(libs.navigation3.ui)
            implementation(libs.navigation3.adaptive)
            implementation(libs.lifecycle.viewmodel.navigation3)
        }
    }
}

compose.resources {
    packageOfResClass = "com.feature.dashboard"
    generateResClass = always
    publicResClass = false
}

buildkonfig {
    packageName = "com.feature.dashboard"
    exposeObjectWithName = "DashboardConfig"

    defaultConfigs {}
    targetConfigs(Environment.DEBUG.value) {
        create(com.quibbly.Platform.IOS.value) {
            buildConfigField(Type.STRING, Keys.MAP_KEY, keyStoreProperties.getProperty(Keys.IOS_MAP_KEY_DEV))
        }
        create(com.quibbly.Platform.ANDROID.value) {
            buildConfigField(Type.STRING, Keys.MAP_KEY, keyStoreProperties.getProperty(Keys.ANDROID_MAP_KEY_DEV))
        }
    }
    targetConfigs(Environment.RELEASE.value) {
        create(com.quibbly.Platform.IOS.value) {
            buildConfigField(Type.STRING, Keys.MAP_KEY, keyStoreProperties.getProperty(Keys.IOS_MAP_KEY_PROD))
        }
        create(com.quibbly.Platform.ANDROID.value) {
            buildConfigField(Type.STRING, Keys.MAP_KEY, keyStoreProperties.getProperty(Keys.ANDROID_MAP_KEY_PROD))
        }
    }
}

private fun readProperties(propertiesFile: File) = Properties().apply {
    propertiesFile.inputStream().use { fis ->
        load(fis)
    }
}