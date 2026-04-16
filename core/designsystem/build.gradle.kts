plugins {
    id("com.quibbly.core.conventions")
    id("com.quibbly.compose.conventions")
    alias(libs.plugins.serialization)
}

coreConfig {
    name = "designsystem"
}

kotlin {
    android {
        namespace = "com.core.designsystem"
    }
}

compose.resources {
    packageOfResClass = "com.core.designsystem"
    generateResClass = always
    publicResClass = true
}