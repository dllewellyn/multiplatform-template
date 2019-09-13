buildscript {
    repositories {
        google()
        jcenter()
        mavenLocal()
        maven("https://dl.bintray.com/kotlin/ktor")
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
        maven("https://dl.bintray.com/soywiz/soywiz")
        maven("https://dl.bintray.com/jetbrains/kotlin-native-dependencies")
    }

    dependencies {
        classpath("com.android.tools.build:gradle:3.4.2")
        classpath("com.squareup.sqldelight:gradle-plugin:1.2.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.50")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.3.50")
    }
}

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.50"
    kotlin("kapt" )version "1.3.50"
}