object Deps {

    const val coreKtx = "androidx.core:core-ktx:1.3.2"
    const val appCompat = "androidx.appcompat:appcompat:1.2.0"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
    const val material = "com.google.android.material:material:1.3.0"

    object Compose {
        const val version = "1.0.0-beta05"

        const val composeUi = "androidx.compose.ui:ui:$version"
        const val composeMaterial = "androidx.compose.material:material:$version"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling:$version"
    }

    object Accompanist {
        private const val version = "0.8.1"

        const val coil = "com.google.accompanist:accompanist-coil:$version"
    }

    const val activityCompose = "androidx.activity:activity-compose:1.3.0-alpha07"

    object Navigation {
        const val compose = "androidx.navigation:navigation-compose:1.0.0-alpha10"
    }
}
