

plugins {
    application
    `java-library`
    id("com.github.johnrengelman.shadow")
    java
    id("org.beryx.runtime")
}


group = "RSMapperClient"


repositories {
    mavenLocal()
    mavenCentral()
    maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
}


dependencies {
    implementation(fileTree(mapOf("dir" to "resources", "include" to listOf("*.jar"))))
    api(project(":RSMapperServer"))
    api("org.controlsfx:controlsfx:11.1.1")
    api("com.jfoenix:jfoenix:9.0.10")
}


java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}


application {
    mainClass.set("RSMapperServer")
    applicationName = "RSMapperServer"
}


tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}


runtime {
    options.set(listOf("--strip-debug", "--compress", "2", "--no-header-files", "--no-man-pages"))
    modules.set(
        listOf(
            "javafx.base",
            "java.desktop",
            "javafx.graphics",
            "javafx.controls",
            "javafx.fxml",
            "javafx.swing",
            "java.naming",
            "java.logging",
            "java.management",
            "java.xml",
            "jdk.unsupported",
            "java.sql",
            "javafx.media",
            "java.scripting",
            "jdk.jfr",
            "jdk.unsupported.desktop",
            "java.datatransfer"
        )
    )
}