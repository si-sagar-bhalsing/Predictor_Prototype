plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.si.fanalytics.match_predictor"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.si.fanalytics.match_predictor"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    //Android libs
    implementation(libs.androidx.core)
    implementation(libs.appcompat)
    implementation(libs.google.material)

    //test lib
    testImplementation(libs.test.junit)
    androidTestImplementation(libs.test.android.junit.ext)
    androidTestImplementation(libs.test.android.espresso.core)

    // Compose dependencies
    implementation(platform(libs.compose))
    implementation(libs.compose.material)
    implementation(libs.compose.material3)
    implementation(libs.livedata)
    implementation(libs.compose.preview)
    implementation(libs.compose.ui)
    debugImplementation(libs.compose.ui)

    //hilt
    implementation(libs.hilt)
    implementation(libs.hilt.navigation)
    kapt(libs.hilt.compiler)

    implementation(project(":core"))
    implementation(project(":match_predictor"))

}
kapt {
    correctErrorTypes = true
}
hilt {
    enableAggregatingTask = true
}