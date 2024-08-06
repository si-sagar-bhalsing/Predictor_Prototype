plugins {
    alias(libs.plugins.library)
    alias(libs.plugins.kotlin)
    id("kotlin-kapt")
//    alias(libs.plugins.ksp)
//    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.gaming.core"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
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

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.network.logger)
    implementation("com.squareup.okhttp3:okhttp:4.11.0")

    //image loading lib
    implementation(libs.coil)
    implementation(libs.compose.coil)
}

kapt {
    correctErrorTypes = true
}
hilt {
    enableAggregatingTask = true
}