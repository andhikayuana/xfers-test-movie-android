plugins {
    id(Plugins.androidLib)
    kotlin(Plugins.android)
}

android {
    compileSdkVersion(Versions.compileSdk)
    buildToolsVersion = Versions.buildTool

    defaultConfig {
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions.apply {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {

    implementation(Deps.kotlinStd)
    implementation(Deps.coroutines)
    implementation(Deps.coreKtx)
    implementation(Deps.retrofit)
    implementation(Deps.retrofitGson)
    implementation(Deps.gson)
    implementation(Deps.okHttpLogging)


    testImplementation(Deps.junit)
    testImplementation("org.mockito.kotlin:mockito-kotlin:3.1.0")
    testImplementation("com.natpryce:hamkrest:1.8.0.1")

    androidTestImplementation(Deps.junitExt)
    androidTestImplementation(Deps.espresso)
}