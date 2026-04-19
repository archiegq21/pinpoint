import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.gms)
    alias(libs.plugins.crashlytics)
}

kotlin {
    compilerOptions {
        languageVersion = org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_2_3
        freeCompilerArgs.add("-Xreturn-value-checker=full")
        freeCompilerArgs.add("-Xexplicit-backing-fields")
    }

    dependencies {
        implementation(projects.shared)

        implementation(libs.androidx.splashscreen)
        implementation(libs.androidx.activity.compose)
        implementation(libs.androidx.appcompat)

        implementation(libs.compose.runtime)
        implementation(libs.compose.foundation)
        implementation(libs.compose.ui)
        implementation(libs.compose.material3)
        implementation(libs.compose.components.resources)
        implementation(libs.compose.components.preview)
        implementation(libs.compose.lifecycle)
        implementation(libs.compose.viewmodel)

        debugImplementation(libs.compose.preview.tooling)

        implementation(project.dependencies.platform(libs.firebase.bom))
        implementation(libs.firebase.auth)
        implementation(libs.firebase.crashlytics)
        implementation(libs.firebase.analytics)
    }
}

android {
    namespace = "com.quibbly.pinpoint"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        applicationId = "com.quibbly.pinpoint"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
        resValues = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    signingConfigs {
        getByName("debug") {
            storeFile = file(projectDir.resolve("../../../keys/debug.keystore"))
            storePassword = "android"
            keyAlias = "androiddebugkey"
            keyPassword = "android"
            enableV1Signing = true
            enableV2Signing = true
            enableV3Signing = true
            enableV4Signing = true
        }
        create("release") {
            val keyStoreProperties =
                readProperties(file(projectDir.resolve("../../../keys/keystore.properties")))
            storeFile =
                file(projectDir.resolve(keyStoreProperties.getProperty("RELEASE_STORE_FILE")))
            storePassword = keyStoreProperties.getProperty("RELEASE_STORE_PASSWORD")
            keyAlias = keyStoreProperties.getProperty("RELEASE_KEY_ALIAS")
            keyPassword = keyStoreProperties.getProperty("RELEASE_KEY_PASSWORD")
            enableV1Signing = true
            enableV2Signing = true
            enableV3Signing = true
            enableV4Signing = true
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
            signingConfig = signingConfigs["debug"]
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        release {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            signingConfig = signingConfigs["release"]
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

private fun readProperties(propertiesFile: File) = Properties().apply {
    propertiesFile.inputStream().use { fis ->
        load(fis)
    }
}