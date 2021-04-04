/**
 * @author andhikayuana
 */

object Plugins {

    const val androidApp = "com.android.application"
    const val androidLib = "com.android.library"
    const val android = "android"
    const val androidExt = "android.extensions"
    const val kotlinKapt = "kapt"

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidBuildGradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object Deps {

    const val kotlinStd = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val viewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val swipeRefresh =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefresh}"
    const val coil = "io.coil-kt:coil:${Versions.coil}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"


    const val junit = "junit:junit:${Versions.junit}"
    const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val mockWebserer = "com.squareup.okhttp3:mockwebserver:${Versions.okHttp}"
    const val googleTruth = "com.google.truth:truth:${Versions.googleTruth}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val androidCoreTest = "androidx.arch.core:core-testing:${Versions.androidCoreTest}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}"
}

object Versions {

    const val kotlin = "1.4.32"
    const val coroutines = "1.3.9"
    const val androidBuildGradle = "4.1.3"
    const val compileSdk = 30
    const val minSdk = 21
    const val targetSdk = 30
    const val buildTool = "30.0.3"

    const val material = "1.3.0"
    const val appCompat = "1.2.0"
    const val coreKtx = "1.3.2"
    const val constraintLayout = "2.0.4"
    const val lifecycle = "2.3.1"
    const val navigation = "2.3.4"
    const val recyclerView = "1.1.0"
    const val swipeRefresh = "1.1.0"
    const val retrofit = "2.9.0"
    const val gson = "2.8.6"
    const val coil = "1.1.1"
    const val okHttp = "4.9.0"

    const val junit = "4.13.2"
    const val junitExt = "1.1.2"
    const val espresso = "3.3.0"
    const val googleTruth = "1.1.2"
    const val mockito = "3.8.0"
    const val androidCoreTest = "2.1.0"
    const val coroutinesTest = "1.3.4"

}
