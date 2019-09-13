
plugins {
    kotlin("multiplatform")
    id("org.jetbrains.kotlin.plugin.serialization")
}


group = "com.autosync"
version = "1.0-SNAPSHOT"

repositories {
    maven(url = "https://dl.bintray.com/kotlin/kotlinx")
    maven(url = "https://dl.bintray.com/kotlin/ktor")
    mavenCentral()
    jcenter()
    google()
}

kotlin {
    jvm("java")

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":models"))
                implementation(project(":database"))
                implementation(kotlin("stdlib-common"))
                implementation("io.ktor:ktor-client-core:1.2.3")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:1.1.1")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:0.11.1")
                implementation("io.ktor:ktor-client-serialization:1.2.3")
                implementation("io.ktor:ktor-client-core:1.2.3")
                implementation("io.ktor:ktor-client-json:1.2.3")

            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val javaMain by getting {
            dependencies {
                implementation(kotlin("stdlib"))
                implementation("com.squareup.sqldelight:sqlite-driver:1.2.0")
                implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.50")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.1.1")
                implementation("io.ktor:ktor-client-serialization-jvm:1.2.3")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.11.1")
                implementation("io.ktor:ktor-client-core-jvm:1.2.3")
                implementation("io.ktor:ktor-client-okhttp:1.2.3")
                implementation("io.ktor:ktor-client-json-jvm:1.2.3")
            }
        }
    }
}