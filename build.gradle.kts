// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    dependencies {
        classpath(group = "org.jetbrains.kotlin", name = "kotlin-serialization", version = "1.8.0")
        classpath(group = "androidx.navigation", name = "navigation-safe-args-gradle-plugin", version = "2.6.0")
    }
}

plugins {
    id("com.android.application") version "8.1.3" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.android.library") version "8.1.3" apply false
    id("org.jetbrains.kotlin.jvm") version "1.9.0" apply false
}