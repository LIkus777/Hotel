plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {
    implementation(project(mapOf("path" to ":domain")))

    //Coroutines & Flow
    val coroutines_version = "1.6.4"
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")
}