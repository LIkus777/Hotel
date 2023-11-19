plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {

    val kotlin_serialization_version = "1.4.0"
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlin_serialization_version")

    //Coroutines & Flow
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
}