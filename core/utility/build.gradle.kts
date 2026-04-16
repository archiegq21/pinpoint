import com.codingfeline.buildkonfig.compiler.FieldSpec.Type
import com.quibbly.Environment
import com.quibbly.Keys

plugins {
    id("com.quibbly.core.conventions")
    alias(libs.plugins.serialization)
    alias(libs.plugins.buildconfig)
}

coreConfig {
    name = "utility"
}

kotlin {
    android {
        namespace = "com.core.utility"
    }
}

buildkonfig {
    packageName = "com.core.utility"
    objectName = "UtilityConfig"
    exposeObjectWithName = "UtilityConfig"

    defaultConfigs {
        buildConfigField(Type.BOOLEAN, Keys.IS_DEBUG, false.toString())
    }
    defaultConfigs(Environment.DEBUG.value) {
        buildConfigField(Type.BOOLEAN, Keys.IS_DEBUG, true.toString())
    }
    defaultConfigs(Environment.RELEASE.value) {
        buildConfigField(Type.BOOLEAN, Keys.IS_DEBUG, false.toString())
    }
}