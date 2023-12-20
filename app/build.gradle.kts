plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    //Apply the Hilt gradle plugin
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.bbs.learnandtest"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.bbs.learnandtest"
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Retrofit: to consume web services
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // Converter Gson for retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    // Gson: to parse a data classs to json string
    implementation("com.google.code.gson:gson:2.10.1")
    // Glid: to download and process images
    implementation("com.github.bumptech.glide:glide:4.14.2")
    // TODO: Add support for "Glide’s annotation processing libraries" as Kotlin KSP(recommended) or KAPT.
    // Glid & compose: Dependency to support Compose for Glide
    implementation("com.github.bumptech.glide:compose:1.0.0-beta01")
    // Hilt dependencies
    implementation("com.google.dagger:hilt-android:2.44")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
    kapt("com.google.dagger:hilt-android-compiler:2.44")
    // Room: persistence library to save data on SQLite.
    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
    // For Room: To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:$room_version")
    // For Room: optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test:rules:1.5.0")
    // Optional -- UI testing with Espresso
    //androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    // Optional -- UI testing with UI Automator
    //androidTestImplementation("androidx.test.uiautomator:uiautomator:2.2.0")
    // Optional -- UI testing with Compose
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.4")
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}