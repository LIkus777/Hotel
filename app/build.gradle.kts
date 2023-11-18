plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("io.gitlab.arturbosch.detekt") version "1.22.0"
}

android {
    namespace = "com.example.hotel"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.hotel"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

val detekt_version = "1.22.0"
detekt {
    toolVersion = "$detekt_version"
    config = files("../detekt/config.yml")
    buildUponDefaultConfig = true
}

dependencies {

    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":data")))

    detektPlugins ("io.gitlab.arturbosch.detekt:detekt-formatting:$detekt_version")

    //AppCompat
    val appcompat_version = "1.6.1"
    implementation ("androidx.appcompat:appcompat:$appcompat_version")

    //Retrofit Converter
    implementation ("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")

    //Okhttp Logging Interceptor
    implementation ("com.squareup.okhttp3:logging-interceptor:4.10.0")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")

    //Kotlin Serialization
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0")

    //Constraint
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")

    //Fragment
    implementation ("androidx.fragment:fragment-ktx:1.6.0")

    //Navigation
    var navigation_version = "2.6.0"
    implementation ("androidx.navigation:navigation-fragment-ktx:$navigation_version")
    implementation ("androidx.navigation:navigation-ui-ktx:$navigation_version")

    //ViewModel, Runtime & LiveData
    val lifecycle_version = "2.6.1"
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")

    // Koin for Andnroid
    val koin_version = "3.4.3"
    implementation ("io.insert-koin:koin-android:$koin_version")

    //Material Design
    implementation ("com.google.android.material:material:1.9.0")

    //Coroutines & Flow
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    //Okhttp Logging Interceptor
    implementation ("com.squareup.okhttp3:logging-interceptor:4.10.0")

    //Prefs
    implementation ("androidx.preference:preference-ktx:1.2.0")

    //RecyclerView
    implementation ("androidx.recyclerview:recyclerview:1.3.0")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}