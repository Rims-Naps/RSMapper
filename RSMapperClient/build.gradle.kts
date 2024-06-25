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
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}

application {
    mainClass.set("RSMapperClient")
    applicationName = "RSMapperClient"
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

tasks.register<Jar>("fatJar") {
    archiveBaseName.set("${project.name}-fat")
    manifest {
        attributes["Implementation-Version"] = version
        attributes["Main-Class"] = "RSMapperClient"
    }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    with(tasks.named<Jar>("jar").get() as CopySpec)
}