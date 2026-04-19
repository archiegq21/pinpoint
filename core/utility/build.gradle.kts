import com.codingfeline.buildkonfig.compiler.FieldSpec.Type
import com.quibbly.Environment
import com.quibbly.Keys
import io.github.frankois944.spmForKmp.swiftPackageConfig

plugins {
    id("com.quibbly.core.conventions")
    alias(libs.plugins.serialization)
    alias(libs.plugins.buildconfig)
}

kotlin {
    android {
        namespace = "com.core.utility"
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            baseName = "utility"
            isStatic = true
        }
        it.swiftPackageConfig("utility") {
            minIos = libs.versions.ios.target.get()
        }
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