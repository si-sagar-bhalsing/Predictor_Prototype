plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
//    id("com.google.dagger.hilt.android")
//    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

object ProjectConfig {
    val jvmVersion = JavaVersion.VERSION_1_8
    const val compileSdk = 33
    const val minSdk = 23
    const val targetSdk = 33
}

android {
    namespace = "com.si.fanalytics.match_predictor"
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        applicationId = "com.si.fanalytics.match_predictor"
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    compileOptions {
        sourceCompatibility = ProjectConfig.jvmVersion
                targetCompatibility = ProjectConfig.jvmVersion
    }
    kotlinOptions {
        jvmTarget = ProjectConfig.jvmVersion.toString()
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // fragment navigation
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)


    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)

//    implementation(libs.hilt.android)
//    kapt(libs.hilt.android.compiler)

    // datastore
    implementation(libs.datastore.preferences)

    // google ads
    implementation(libs.googleAds)

    implementation("com.si.f1:predictor:0.0.2-12")


}
//kapt {
//    correctErrorTypes = true
//}
//hilt {
//    enableAggregatingTask = true
//}