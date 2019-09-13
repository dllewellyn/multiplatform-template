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
    jvm()
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation("io.ktor:ktor-client-core:1.2.3")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:1.1.1")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:0.11.1")
                implementation("io.ktor:ktor-client-serialization:1.2.3")
                implementation("io.ktor:ktor-client-core:1.2.3")
                implementation("io.ktor:ktor-client-json:1.2.3")
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.11.1")
            }
        }
    }
}