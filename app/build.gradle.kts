plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {

    compileSdk = AppConfig.compileSdkVersion
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        applicationId = AppConfig.id
        minSdk = AppConfig.minSdkVersion
        targetSdk = AppConfig.targetSdkVersion
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"

            isShrinkResources = false
            isMinifyEnabled = false
        }
        release {
            isShrinkResources = true
            isMinifyEnabled = true

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        buildConfig = false
    }

    lint {
        isCheckReleaseBuilds = false
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Deps.Compose.version
    }

}

dependencies {
    implementation(Deps.coreKtx)
    implementation(Deps.appCompat)
    implementation(Deps.material)
    implementation(Deps.Compose.composeUi)
    implementation(Deps.Compose.composeMaterial)
    implementation(Deps.Compose.composeUiTooling)
    implementation(Deps.Accompanist.coil)
    implementation(Deps.lifecycle)
    implementation(Deps.activityCompose)
}
