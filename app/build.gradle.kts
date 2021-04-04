plugins {
    id(Plugins.androidApp)
    kotlin(Plugins.android)
    kotlin(Plugins.androidExt)
    kotlin(Plugins.kotlinKapt)
    id("androidx.navigation.safeargs")
    id("kotlin-android")
}

android {
    compileSdkVersion(Versions.compileSdk)
    buildToolsVersion = Versions.buildTool

    defaultConfig {
        applicationId = AppVersion.applicationId
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionCode = AppVersion.versionCode()
        versionName = AppVersion.versionName()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        val baseUrl: String by project
        val apiKey: String by project

        buildTypes.onEach {
            it.buildConfigField("String", "MOVIE_BASE_URL", baseUrl)
            it.buildConfigField("String", "MOVIE_API_KEY", apiKey)
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

}

dependencies {
    implementation(Deps.kotlinStd)
    implementation(Deps.coroutines)
    implementation(Deps.coreKtx)
    implementation(Deps.appCompat)
    implementation(Deps.material)
    implementation(Deps.constraintLayout)
    implementation(Deps.viewModel)
    implementation(Deps.liveData)
    implementation(Deps.navigationFragment)
    implementation(Deps.navigationUi)
    implementation(Deps.recyclerView)
    implementation(Deps.swipeRefresh)
    implementation(Deps.coil)
    implementation(Deps.okHttp)
    implementation(project(":core"))

    testImplementation(Deps.junit)
    testImplementation(Deps.mockWebserer)
    testImplementation(Deps.googleTruth)
    testImplementation(Deps.mockito)
    testImplementation(Deps.mockitoInline)
    testImplementation(Deps.androidCoreTest)
    testImplementation(Deps.coroutinesTest)

    androidTestImplementation(Deps.junitExt)
    androidTestImplementation(Deps.espresso)
}