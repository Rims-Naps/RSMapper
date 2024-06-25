
plugins {
    java
    //id("io.franzbecker.gradle-lombok") version "5.0.0"
    id("com.github.johnrengelman.shadow") version "7.1.1" apply false
    application
    id("java-library")
    id("org.beryx.runtime") version "1.12.7" apply false
   // id("org.openjfx.javafxplugin") version "0.0.10"
}

tasks.wrapper {
    gradleVersion = "7.1"
}

group = "org.grim"
version = "1"

allprojects {
    repositories {
        mavenCentral()
        mavenLocal()
        maven { url = uri("https://repo.maven.apache.org/maven2") }
        maven { url = uri("https://repo.adobe.com/nexus/content/repositories/public/") }
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "java-library")
    //apply(plugin = "io.franzbecker.gradle-lombok")

    java {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    dependencies {
        api("ch.qos.logback:logback-classic:1.2.10")
        api("org.checkerframework:checker-qual:3.21.1")
        api("com.google.guava:guava:31.0.1-jre")
        api("com.google.code.gson:gson:2.8.9")
        api("javax.servlet:javax.servlet-api:4.0.1")
    }

//     configure<io.franzbecker.gradle.lombok.LombokExtension> {
//     version = "1.18.22"
//     }

    tasks.compileJava {
        options.isFork = true
        options.isIncremental = true
    }

//     apply(plugin = "org.openjfx.javafxplugin")
//     configure<org.openjfx.gradle.JavaFXPluginExtension> {
//         version = "11"
//         modules = listOf("javafx.base", "javafx.fxml", "javafx.graphics", "javafx.controls", "javafx.media", "javafx.swing")
//     }
}