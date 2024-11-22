// Top-level build file where you can add configuration options common to all sub-projects/modules.
// build.gradle (Project-level)
// build.gradle.kts (Project-level)
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.4.1") // Replace with the correct AGP version
        classpath("com.google.gms:google-services:4.4.2") // Google Services plugin
    }
}
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.google.gms.google.services) apply false
}