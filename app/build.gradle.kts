import org.gradle.internal.impldep.org.h2.tools.Server.main

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
    kotlin("kapt")
    id ("com.google.dagger.hilt.android")
    id ("org.jetbrains.kotlin.plugin.serialization") version "1.9.21"

}

android {
    namespace = "com.example.yajhztask"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.yajhztask"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
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
        viewBinding = true
    }

}
kapt {
    correctErrorTypes=true
}
dependencies {
    implementation ("com.google.dagger:hilt-android:2.46")
    kapt ("com.google.dagger:hilt-compiler:2.46")
    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")
    implementation("androidx.navigation:navigation-dynamic-features-fragment:2.7.6")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    implementation("com.google.android.gms:play-services-location:21.0.1")
    implementation("pub.devrel:easypermissions:3.0.0")
    val koin_v="3.2.0"
    implementation("io.insert-koin:koin-android:$koin_v")
    val ktor_v="2.3.4"
    implementation("io.ktor:ktor-client-core:$ktor_v")
    //implementation "io.ktor:ktor-client-cio:$ktor_v"
    implementation("io.ktor:ktor-client-android:$ktor_v")
    implementation("io.ktor:ktor-client-serialization:$ktor_v")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_v")
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_v")
    implementation("io.ktor:ktor-client-logging:$ktor_v")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}