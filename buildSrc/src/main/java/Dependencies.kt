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

    const val junit = "junit:junit:${Versions.junit}"
    const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

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
    const val retrofit = "2.9.0"
    const val gson = "2.8.6"

    const val junit = "4.13.2"
    const val junitExt = "1.1.2"
    const val espresso = "3.3.0"

}
